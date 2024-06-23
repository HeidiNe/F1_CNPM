/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Delar
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
    public static Connection connection;

    public DAO() {
        if(connection == null){
            String jdbcUrl = "jdbc:sqlserver://HEIDI:1400;DatabaseName=QLF1;encrypt=true;trustServerCertificate=true";
            String username = "sa";
            String password = "sa123";
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager.getConnection(jdbcUrl, username, password);
                
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }    
            
        }
    }
    
    
    
    
 
    
}
