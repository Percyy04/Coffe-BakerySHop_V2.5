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

    public ArrayList<Item> searchItemsByName(String keyword) {
        ArrayList<Item> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT * FROM Items WHERE ItemName LIKE ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, "%" + keyword + "%");
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    Item item = new Item(
                            rs.getInt("ItemId"),
                            rs.getString("ItemName"),
                            rs.getInt("Price"),
                            rs.getInt("typeID"),
                            rs.getInt("statusID"),
                            rs.getString("Image")
                    );
                    list.add(item);
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
   

    public ArrayList<Item> sortItemsByPrice() {
        ArrayList<Item> list = getAllItems(); // Lấy danh sách tất cả các item
        Collections.sort(list, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return Integer.compare(item1.getPrice(), item2.getPrice());
            }
        });
        return list;
    }

    public ArrayList<Item> sortItemsByPriceDescending() {
        ArrayList<Item> list = getAllItems(); // Lấy danh sách tất cả các item
        Collections.sort(list, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return Integer.compare(item2.getPrice(), item1.getPrice()); // Đảo ngược thứ tự
            }
        });
        return list;
    }
    
    
    public static void main(String[] args) {
        ItemDAO d = new ItemDAO();
        ArrayList<Item> list = d.sortItemsByPriceDescending();
        for (Item item : list) {
            System.out.println(item);
        }
        System.out.println("Số lượng item trong list: " + list.size());
    }

}
