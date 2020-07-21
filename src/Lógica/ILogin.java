/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lógica;


import DAO.DAOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author israz
 */
public class ILogin {

    
    public int IniciarSesion(String email, String password) throws DAOException{
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        
        String sql = "SELECT * FROM Personal WHERE email = ? AND contraseña = ?";
        
        try{
            con = DriverManager.getConnection("jdbc:mysql://185.201.10.129/u997594570_Escuela", "u997594570_admin", "Megaman1");
             
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
 
            
            if(!resultSet.next()){
                return -1;
            }else{
                return resultSet.getInt("tipoEmpleado"); 
            }                       
                
        }catch (Exception e){
            return -1;
            
            
        } finally {
           if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException exception) {
                throw new DAOException("Error al cerrar conexión con SQL", exception);
            }
        }
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException exception) {
                throw new DAOException("Error al cerrar conexión con SQL", exception);
            }
        }
        }
    }
    
    
    
}
