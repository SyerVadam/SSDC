package Mysql;

import DAO.DAOException;
import DAO.PersonalDAO;
import Models.Personal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class ImpPersonalDAO implements PersonalDAO {
    final String INSERT = "INSERT INTO Personal(nombre, apellidoPaterno, apellidoMaterno, CURP, RFC, email, usuario, contraseña, antiguedad, tipoEmpleado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    final String UPDATE = "UPDATE Personal nombre = ?, apellidoPaterno = ?, apellidoMaterno = ?, CURP = ?, RFC = ?, email = ?, usuario = ?, contraseña = ?, antiguedad = ?, tipoEmpleado = ? WHERE idPersonal = ?";
    final String DELETE = "DELETE * FROM Personal WHERE idPersonal = ?";
    final String GETONE = "SELECT * FROM Personal WHERE idPersonal = ?";
    public Connection connection;

    public ImpPersonalDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public void insert(Personal obj) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(INSERT);
            statement.setString(1, obj.getNombre());
            statement.setString(2, obj.getApellidoPaterno());
            statement.setString(3, obj.getApellidoMaterno());
            statement.setString(4, obj.getCURP());
            statement.setString(5, obj.getRFC());
            statement.setString(6, obj.getEmail());
            statement.setString(7, obj.getUsuario());
            statement.setString(8, obj.getContraseña());
            statement.setInt(9, obj.getAntiguedad());
            statement.setInt(10, obj.getTipoEmpleado());
            if(statement.executeUpdate() == 0){
                throw new DAOException("Error al insertar en base de datos!.");
            }
        } catch (SQLException exception) {
            
            throw new DAOException("Error en SQL.", exception);
            
        } 
        
        finally {
            Utilidades.close(statement, resultSet);
        }
    }

    @Override
    public void update(Personal obj) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, obj.getNombre());
            statement.setString(2, obj.getApellidoPaterno());
            statement.setString(3, obj.getApellidoMaterno());
            statement.setString(4, obj.getCURP());
            statement.setString(5, obj.getRFC());
            statement.setString(6, obj.getEmail());
            statement.setString(7, obj.getUsuario());
            statement.setString(8, obj.getContraseña());
            statement.setInt(9, obj.getAntiguedad());
            statement.setInt(10, obj.getTipoEmpleado());
            if(statement.executeUpdate() == 0){
                throw new DAOException("Es posible que no se hayan modificado los valores en la base de datos!.");
            }
        } catch (SQLException exception) {
            throw new DAOException("Error en SQL!.",exception);
        } finally {
            Utilidades.close(statement);
        }
    }

    @Override
    public void delete(Personal obj) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, obj.getIdPersonal());
            if(statement.executeUpdate() == 0){
                throw new DAOException("Posible error al eliminar en la base de datos!.");
            }
        } catch (SQLException exception) {
            throw new DAOException("Error en SQL!.", exception);
        } finally {
            Utilidades.close(statement);
        }
    }

    private Personal convertir (ResultSet resultSet) throws SQLException{
        String nombre = resultSet.getString("nombre");
        String apellidoPaterno = resultSet.getString("apellidoPaterno");
        String apellidoMaterno = resultSet.getString("apellidoMaterno");
        String CURP = resultSet.getString("CURP");
        String RFC = resultSet.getString("RFC");
        String email = resultSet.getString("email");
        String usuario = resultSet.getString("usuario");
        String contraseña = resultSet.getString("contraseña");
        int antiguedad = resultSet.getInt("antiguedad");
        int tipoEmpleado = resultSet.getInt("tipoEmpleado");
        Personal personal = new Personal(nombre, apellidoPaterno, apellidoMaterno, CURP, RFC, email, usuario, contraseña, antiguedad, tipoEmpleado);
        personal.setIdPersonal(resultSet.getInt("idPersonal"));
        return personal;
    }

    @Override
    public Personal getOne(Integer id) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Personal personal;
        try{
            statement = connection.prepareStatement(GETONE);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                personal = convertir(resultSet);
            } else {
                throw new DAOException("Registro no encontrado!.");
            }
        } catch (SQLException exception) {
            throw new DAOException("Error en SQL!.", exception);
        } finally {
            Utilidades.close(statement, resultSet);
        }
        return personal;
    }
}
