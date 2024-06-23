/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.User;
import java.sql.PreparedStatement;

/**
 *
 * @author Delar
 */
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserDAO extends DAO{

    public UserDAO() {
    }
    
    public boolean checkLogin(User u){
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM tblUser WHERE username = ? AND password = ?");
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                u.setFullName(rs.getString("fullname"));
                u.setRole(rs.getString("role"));
                u.setID(rs.getInt("ID"));
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
}
