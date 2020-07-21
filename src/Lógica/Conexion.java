package Lógica;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
  
    Connection conn = null;
    
   
    public Connection conexion() throws SQLException{
        try {
            conn = DriverManager.getConnection("jdbc:mysql://185.201.10.129/u997594570_Escuela", "u997594570_admin", "Megaman1");
            System.out.println("Conecctado!.");
        } finally {
            if (conn != null) {
                conn.close();
            }
        }     
        return conn;  
    }
    
    public void close () throws SQLException{
        conn.close();
    }
}