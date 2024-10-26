/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dto.Item;
import java.sql.*;
import java.util.*;
import myLib.DBUtils;

/**
 *
 * @author Asus
 */
public class ItemDAO {
    
    //lay cac item 
    public ArrayList<Item> getAllItems() {
        ArrayList<Item> list = new ArrayList<>();
        Connection cn = null;      
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT ItemId\n"
                        + "      ,ItemName\n"
                        + "      ,Price\n"
                        + "      ,typeID\n"
                        + "      ,statusID\n"
                        + "      ,Image\n"
                        + "FROM [BAKERY_COFFEE_SHOP_v2.2].[dbo].[Items] \n";
                PreparedStatement st = cn.prepareStatement(sql);               
                ResultSet table = st.executeQuery();
                System.out.println("Có kết quả: " + (table != null));
                if (table != null) {
                    int rowCount = 0;
                    while (table.next()) {
                        rowCount++;
                        Item t = new Item();
                        t.setItemId(table.getInt("ItemId"));
                        t.setItemName(table.getString("ItemName"));
                        t.setPrice(table.getInt("Price"));
                        t.setTypeID(table.getInt("typeID"));
                        t.setStatusID(table.getInt("statusID"));
                        t.setImage(table.getString("Image"));
                        list.add(t);
//                        t.setId(table.getInt("ItemId"));
//                        t.setImagepath(table.getString("Image"));
//                        t.setName(table.getString("ItemName"));
//                        t.setPrice(table.getInt("Price"));
//                        t.setStatus(table.getInt("Status"));
                       
                    }
                    System.out.println("Số bản ghi tìm thấy: " + rowCount);
                }
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
        
        return list;
    }
    public static void main(String[] args) {
        ItemDAO d = new ItemDAO();
        ArrayList<Item> list = d.getAllItems();
        for (Item item : list) {
            System.out.println(item);
        }

        System.out.println("Số lượng item trong list: " + list.size());
    }
    
}
