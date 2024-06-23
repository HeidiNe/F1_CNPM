/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Delar
 */
public class RaceTeam {
    private int id;
    private String name;
    private String brand;
    private String describe;

    public RaceTeam() {
    }

    public RaceTeam(int id, String name, String brand, String describe) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getDescribe() {
        return describe;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
    
    
}
