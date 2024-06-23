/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.time.LocalDate;


/**
 *
 * @author Delar
 */
public class GrandPrix {
    private int ID;
    private String name;
    private int numberOflap;
    private String location;
    private LocalDate date;
    private String describe;
    private int tournamentid;

    public GrandPrix() {
    }

    public GrandPrix(int ID, String name, int numberOflap, String location, LocalDate date, String describe, int tournamentid) {
        this.ID = ID;
        this.name = name;
        this.numberOflap = numberOflap;
        this.location = location;
        this.date = date;
        this.describe = describe;
        this.tournamentid = tournamentid;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getNumberOflap() {
        return numberOflap;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescribe() {
        return describe;
    }

    public int getTournamentid() {
        return tournamentid;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOflap(int numberOflap) {
        this.numberOflap = numberOflap;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setTournamentid(int tournamentid) {
        this.tournamentid = tournamentid;
    }
    
    
}
