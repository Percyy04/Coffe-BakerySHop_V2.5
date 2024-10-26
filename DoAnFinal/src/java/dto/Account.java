/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;

/**
 *
 * @author Tam Peo
 */
public class Account {
    private int accid;
    private String email;
    private String fullname;
    private String password;
    private String role;
    private Date createdAt;
    private boolean status;
    
    public Account(){
        fullname = "";
        email = "";
        password = "";
        role = "";
        createdAt = new Date(accid);
    }

    public int getAccid() {
        return accid;
    }

    public void setAccid(int accid) {
        this.accid = accid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    

    public Account(int accid, String email, String fullname, String password, String role, Date createdAt, boolean status) {
        this.accid = accid;
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
        this.status = status;
    }
    
    
}
