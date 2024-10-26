/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dto.Item;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import mylib.DBUtils;

/**
 *
 * @author Tam Peo
 */
public class OrderDAO {

    // insert 1 dong vao bang order
    // dua tren cart de insert vao bang orderdetail
    // tra ve 1 or 0
    // tat ca cac lenh insert phai dc lam trong transaction
    // de dam bao tat ca data phai vao dc database 
    // hoac bo het neu co loi
    // ham nay ban order cho khach vang lai
    // nen cot accountid bo trong (null)
    public int insertOrder(int total, HashMap<Item, Integer> cart) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false); // bat buoc them vao de luu tmp vao` database de ko chu dong execute query
                String sql = "Insert Orders(OrderDate,Status,Total) values (?,?,?)";
                PreparedStatement st = cn.prepareStatement(sql);
                Date orderdate = new Date(System.currentTimeMillis());
                st.setDate(1, orderdate);
                st.setInt(2, 1); // 1: order pending 2:shipping 3:completing
                st.setInt(3, total);
                result = st.executeUpdate();
                if (result > 0) {
                    // lay orderID vua chen` o tren
                    sql = "Select top 1 OrderID\n"
                            + "from dbo.Orders\n"
                            + "order by OrderID desc";
                    st = cn.prepareStatement(sql);  
                    ResultSet table = st.executeQuery();
                    if (table != null && table.next()) {
                        int orderid = table.getInt("OrderID");
                        for (Item it : cart.keySet()) {
                            int itemid = it.getId();
                            int quantity = cart.get(it);
                            sql = "insert [dbo].[OrderDetails]([ItemID],[OrderID],[Quantity]) values(?,?,?)";
                            st = cn.prepareStatement(sql);
                            st.setInt(1, itemid);
                            st.setInt(2, orderid);
                            st.setInt(3, quantity);
                            result = st.executeUpdate();
                        }
                    }
                }
                cn.commit(); // cho database chay lai nhu bth
                cn.setAutoCommit(true); // auto luu vao database de execute query
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
