/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.*;

public class Mysql_BD {
    
    private static Mysql_BD instance;
    private Connection cnn = null;
    
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String user = "root";
    private String pss = "dkgel8aa";
    private String nom_bd = "bd_biblioteca";
    private String url = "jdbc:mysql://localhost:3306/" + nom_bd;
    
    private Mysql_BD() {
        try {
            
            Class.forName(driver);
            cnn = DriverManager.getConnection(url, user, pss);
            System.out.println("Conexion Abierta");
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al cargar driver BD: " + ex.getMessage());
        }
    }
    
    public static synchronized Mysql_BD getInstance() {
        if (instance == null) {
            instance = new Mysql_BD();
        }
        return instance;
    }
    
    public Connection getConnection() {
        return cnn;
    }
    
}
