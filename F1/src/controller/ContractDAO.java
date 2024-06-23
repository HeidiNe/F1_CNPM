/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static controller.DAO.connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;

/**
 *
 * @author Delar
 */
public class ContractDAO extends DAO{

    public ContractDAO() {
        
    }
    
    public String checkContrac(int idDriver1, int idDriver2, int idTeam){
        try {
            
            CallableStatement cs = connection.prepareCall("{call sp_checkContract(?, ?, ?, ?, ?)}");
            
            cs.setInt(1, idDriver1);
            cs.setInt(2, idDriver2);
            cs.setInt(3, idTeam);
            cs.setString(4, String.valueOf(LocalDate.now()));
            cs.registerOutParameter(5, Types.NVARCHAR);
            cs.executeUpdate();
             
            return cs.getString(5);
 
        } catch (SQLException ex) {
            return ex.getMessage();
        }   
    }
        
}
