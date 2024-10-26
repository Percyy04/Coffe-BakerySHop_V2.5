/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dto.Account;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mylib.DBUtils;

/**
 *
 * @author Tam Peo
 */
public class AccountDAO {

    //TRA VE ACCOUNT NEU TIM THAY   
    public Account getAccount(String email, String password) {
        Account acc = null;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                //viet sql va exec
                String sql = "select [AccId],[Email],[FullName],[Password],[Roll],[CreatedAt]\n"
                        + "from dbo.Accounts\n"
                        + "where Email=? and Status = 1 and Password = ?";
                PreparedStatement st = cn.prepareStatement(sql);//tao ra query template, gan data vao dau ?
                st.setString(1, email);
                st.setString(2, password);
                ResultSet table = st.executeQuery(); // driver tu dong doi table thanh object
                if (table != null) {
                    while (table.next()) {
                        acc = new Account();
                        acc.setAccid(table.getInt("AccId"));
                        acc.setCreatedAt(table.getDate("CreatedAt"));
                        acc.setEmail(table.getString("Email"));
                        acc.setFullname(table.getString("FullName"));
                        acc.setPassword(table.getString("Password"));
                        acc.setRole(table.getString("Roll"));
                        acc.setStatus(table.getBoolean("Status"));
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
        return acc;
    }

    public Account getAccount(String email) {
        Account acc = null;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                //viet sql va exec
                String sql = "select [AccId],[Email],[FullName],[Password],[Roll],[CreatedAt]\n"
                        + "from dbo.Accounts\n"
                        + "where Email=?";
                PreparedStatement st = cn.prepareStatement(sql);//tao ra query template, gan data vao dau ?
                st.setString(1, email);
                ResultSet table = st.executeQuery(); // driver tu dong doi table thanh object
                if (table != null) {
                    while (table.next()) {
                        acc = new Account();
                        acc.setAccid(table.getInt("AccId"));
                        acc.setCreatedAt(table.getDate("CreatedAt"));
                        acc.setEmail(table.getString("Email"));
                        acc.setFullname(table.getString("FullName"));
                        acc.setPassword(table.getString("Password"));
                        acc.setRole(table.getString("Roll"));
                        acc.setStatus(table.getBoolean("Status"));
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
        return acc;
    }

    public int insertAccount(String fullname, String email, String password) {
        int rs = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "insert dbo.Accounts([Email],[FullName],[Password],[Roll],[CreatedAt],[Status])\n"
                        + "values(?,?,?,?,?,?)";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, email);
                st.setString(2, fullname);
                st.setString(3, password);
                st.setString(4, "US");
                Date curDate = new Date(System.currentTimeMillis());
                st.setDate(5, curDate);
                st.setBoolean(6, true);
                rs = st.executeUpdate();
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

        return rs;
    }
}
