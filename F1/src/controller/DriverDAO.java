/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static controller.DAO.connection;
import java.sql.CallableStatement;
import model.Driver;
import model.Contract;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.RaceTeam;



public class DriverDAO extends DAO{

    public DriverDAO() {
    }
    
    public ArrayList<Driver> searchDriver(int idRaceTeam){
        ArrayList<Driver> drivers = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareCall("SELECT d.* FROM tblContract c, tblDriver d WHERE c.raceteamid = ? AND c.driverid = d.id");
            ps.setInt(1, idRaceTeam);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Driver driver = new Driver(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5));
                drivers.add(driver);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DriverDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return drivers; 
    }
    

}
