/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dto.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author Tam Peo
 */
public class ItemDAO {
    //lay cac item dua tren status
    public ArrayList<Item> getAllItems(int status) {
        ArrayList<Item> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "Select ItemId,[ItemName],[Price],[Status],[Image]\n"
                        + "from [dbo].[Items]\n"
                        + "where [Status] = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setInt(1, status);
                ResultSet table = st.executeQuery();
                if(table != null){
                    while(table.next()){
                        Item t = new Item();
                        t.setId(table.getInt("ItemId"));
                        t.setImagepath(table.getString("Image"));
                        t.setName(table.getString("ItemName"));
                        t.setPrice(table.getInt("Price"));
                        t.setStatus(table.getInt("Status"));
                        list.add(t);
                    }
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
    
    public int insertItem(String name, int price, int status, String imagepath){
        int rs = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if(cn != null){
                String sql = "insert [dbo].[Items]([ItemName],[Price],[Status],[Image])"
                        + "values(?,?,?,?)";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, name);
                st.setInt(2, price);
                st.setInt(3, status);
                st.setString(4, imagepath);
                rs = st.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(cn != null) cn.close();
             } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rs;
    }
    
    //lay all items dua vao` name
    public ArrayList<Item> getAllItemsByName(String name) {
        ArrayList<Item> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "Select ItemId,[ItemName],[Price],[Status],[Image]\n"
                        + "from [dbo].[Items]\n"
                        + "where ItemName like ? and Status = 1";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, "%"+name+"%");
                ResultSet table = st.executeQuery();
                if(table != null){
                    while(table.next()){
                        Item t = new Item();
                        t.setId(table.getInt("ItemId"));
                        t.setImagepath(table.getString("Image"));
                        t.setName(table.getString("ItemName"));
                        t.setPrice(table.getInt("Price"));
                        t.setStatus(table.getInt("Status"));
                        list.add(t);
                    }
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
    
    public Item getItemsID(int itemid){
        Item it  = null;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "Select ItemId,[ItemName],[Price],[Status],[Image]\n"
                        + "from [dbo].[Items]\n"
                        + "where ItemId = ? and Status = 1";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setInt(1,itemid);
                ResultSet table = st.executeQuery();
                if(table != null){
                    while(table.next()){
                        it = new Item();
                        it.setId(table.getInt("ItemId"));
                        it.setImagepath(table.getString("Image"));
                        it.setName(table.getString("ItemName"));
                        it.setPrice(table.getInt("Price"));
                        it.setStatus(table.getInt("Status"));
                    }
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
        return it;
    }
    public static void main(String[] args) {
        ItemDAO d = new ItemDAO();
        ArrayList<Item> list = d.getAllItems(1);
        for (Item item : list) {
            System.out.println(item);
        }

        System.out.println("Số lượng item trong list: " + list.size());
    }
}
