/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Delar
 */
public class Contract {
    private int id;
    private Date startTime;
    private Date endTime;
    private String clause;
    private Driver driver;
    private RaceTeam raceTeam;

    public Contract() {
    }

    public Contract(int id, Date startTime, Date endTime, String clause, Driver driver, RaceTeam raceTeam) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.clause = clause;
        this.driver = driver;
        this.raceTeam = raceTeam;
    }

    public int getId() {
        return id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public String getClause() {
        return clause;
    }

    public Driver getDriver() {
        return driver;
    }

    public RaceTeam getRaceTeam() {
        return raceTeam;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setClause(String clause) {
        this.clause = clause;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setRaceTeam(RaceTeam raceTeam) {
        this.raceTeam = raceTeam;
    }
    
    
}
