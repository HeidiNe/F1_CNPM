/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.RaceTeam;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Delar
 */
public class RaceTeamDAO extends DAO{

    public RaceTeamDAO() {
    }
    
    
    public ArrayList<RaceTeam> getListRaceTeam()  {
        ArrayList<RaceTeam> raceTeams = new ArrayList<>();
        PreparedStatement ps;
        try {
            ps = connection.prepareCall("SELECT * FROM tblRaceTeam");
            ResultSet rs = ps.executeQuery(); 
            while(rs.next()){
                RaceTeam raceTeam = new RaceTeam(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                raceTeams.add(raceTeam);
        }
        } catch (SQLException ex) {
            Logger.getLogger(RaceTeamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return raceTeams;
    }
    
}
