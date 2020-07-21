
package Lógica;

import DAO.DAOException;
import Models.Personal;
import Mysql.ImpPersonalDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author israz
 */
public class IAgregarDocente {
    
    public boolean RegistrarDocente(String nombre, String apellidoPaterno, String apellidoMaterno, String contraseña, String rfc, String curp, int antiguedad, String usuario, String email) throws SQLException, DAOException{
        
        Connection con = null;
        Personal personal = new Personal(nombre, apellidoPaterno, apellidoMaterno, curp, rfc, email, usuario, contraseña, antiguedad, 1);
        
       
        
        try{
            con = DriverManager.getConnection("jdbc:mysql://185.201.10.129/u997594570_Escuela", "u997594570_admin", "Megaman1");
            ImpPersonalDAO dao = new ImpPersonalDAO(con);
            
            dao.insert(personal);
            
            return true;
        }catch (Exception e){
            System.out.println("Error en IAgregarDocente, problema con el código de interacción con SQL");
            return false;
        } finally{
            if(con != null){
                con.close();
            }
        }
        
        
    }
    
    public boolean ExisteCorreo(String email) throws DAOException{
        
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        
        String sql = "SELECT * FROM Personal WHERE email = ?";
        
        try{
            con = DriverManager.getConnection("jdbc:mysql://185.201.10.129/u997594570_Escuela", "u997594570_admin", "Megaman1");
             
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
 
            
            if(resultSet.next() == true){
                return true;
            }else{
                return false;
            }                       
                
        }catch (Exception e){
            return false;
            
            
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
