/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;


/**
 *
 * @author Delar
 */
public class Entry {
    private int id;
    private LocalDate entryDate;
    private String clause;
    private User user;
    private GrandPrix grandPrix;
    private Contract contract;

    public Entry() {
    }

    public Entry(int id, LocalDate entryDate, String clause, User user, GrandPrix grandPrix, Contract contract) {
        this.id = id;
        this.entryDate = entryDate;
        this.clause = clause;
        this.user = user;
        this.grandPrix = grandPrix;
        this.contract = contract;
    }

    public int getId() {
        return id;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public String getClause() {
        return clause;
    }

    public User getUser() {
        return user;
    }
    

    public GrandPrix getGrandPrix() {
        return grandPrix;
    }

    public Contract getContract() {
        return contract;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public void setClause(String clause) {
        this.clause = clause;
    }

    public void setGrandPrix(GrandPrix grandPrix) {
        this.grandPrix = grandPrix;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    

}
