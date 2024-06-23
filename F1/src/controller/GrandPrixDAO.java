/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.GrandPrix;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
    
/**
 *
 * @author Delar
 */
public class GrandPrixDAO extends DAO{

    public GrandPrixDAO() {
        
    }
    
    public ArrayList<GrandPrix> getListGrandPrix(){
        ArrayList<GrandPrix> grandPrixs = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareCall("SELECT * FROM tblGrandPrix");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                
                String dateString = rs.getString(5);
                LocalDate date = LocalDate.parse(dateString, formatter);
                
                GrandPrix grandPrix = new GrandPrix(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), date, rs.getString(6), rs.getInt(7));
                grandPrixs.add(grandPrix);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GrandPrixDAO.class.getName()).log(Level.SEVERE, null, ex);
  
        }
        return grandPrixs;
    }
}
