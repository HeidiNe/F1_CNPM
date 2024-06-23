/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static controller.DAO.connection;
import java.sql.CallableStatement;
import java.util.ArrayList;
import model.Entry;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;



/**
 *
 * @author Delar
 */
public class EntryDAO extends DAO{

    public EntryDAO() {
    }
    
    public String addEntry(ArrayList<Entry> entrys){           
        try {
            
            CallableStatement cs = connection.prepareCall("{call sp_addEntrys(?, ?, ?, ?, ?, ?, ?)}");
            
            cs.setString(1, String.valueOf(LocalDate.now()));
            cs.setInt(2, entrys.get(0).getGrandPrix().getID());
            cs.setInt(3, entrys.get(0).getUser().getID());
            cs.setInt(4, entrys.get(0).getContract().getRaceTeam().getId());
            cs.setInt(5, entrys.get(0).getContract().getDriver().getId());
            cs.setInt(6, entrys.get(1).getContract().getDriver().getId());
            cs.registerOutParameter(7, Types.NVARCHAR);
            cs.executeUpdate();
             
            return cs.getString(7);
 
        } catch (SQLException ex) {
            return ex.getMessage();
        }   
    }
    
    public String checExistskEntry(int idTeam, int idGrandPrix){
        try {
            
            CallableStatement cs = connection.prepareCall("{call sp_checkEntry(?, ?, ?)}");
            
            cs.setInt(1, idGrandPrix);
            cs.setInt(2, idTeam);
            cs.registerOutParameter(3, Types.NVARCHAR);

            cs.executeUpdate();
             
            return cs.getString(3);
 
        } catch (SQLException ex) {
            return ex.getMessage();
        }   
    }
}
