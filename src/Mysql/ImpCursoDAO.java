package Mysql;

import DAO.CursoDAO;
import DAO.DAOException;
import Models.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImpCursoDAO implements CursoDAO {
    final String INSERT = "INSERT INTO Curso(idDocente, nombre, fechaInicio, turno, horario, seccion) VALUES (?, ?, ?, ?, ?, ?)";
    final String UPDATE = "UPDATE Curso SET idDocente = ?, nombre = ?, fechaInicio = ?, turno = ?, horario = ?, seccion = ? WHERE idCurso = ?";
    final String DELETE = "DELETE * FROM Curso WHERE idCurso = ?";
    final String GETONE = "SELECT * FROM Curso WHERE idCurso = ?";
    public Connection connection;

    public ImpCursoDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public void insert(Curso obj) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            statement = connection.prepareStatement(INSERT);
            statement.setInt(1, obj.getIdDocente());
            statement.setString(2, obj.getNombre());
            statement.setString(3, obj.getFechaInicio());
            statement.setString(4, obj.getTurno());
            statement.setString(5, obj.getHorario());
            statement.setString(6, obj.getSeccion());
            if(statement.executeUpdate() == 0){
                throw new DAOException("Error al insertar en base de datos!.");
            }
            
        } catch (SQLException exception) {
            throw new DAOException("Error en SQL.", exception);
        } finally {
            Utilidades.close(statement, resultSet);
        }
    }

    @Override
    public void update(Curso obj) throws DAOException {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(UPDATE);
            statement.setInt(1, obj.getIdDocente());
            statement.setString(2, obj.getNombre());
            statement.setString(3, obj.getFechaInicio());
            statement.setString(4, obj.getTurno());
            statement.setString(5, obj.getHorario());
            statement.setString(6, obj.getSeccion());
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
    public void delete(Curso obj) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, obj.getIdCurso());
            if(statement.executeUpdate() == 0){
                throw new DAOException("Posible error al eliminar en la base de datos!.");
            }
        } catch (SQLException exception) {
            throw new DAOException("Error en SQL!.", exception);
        } finally {
            Utilidades.close(statement);
        }
    }

    private Curso convertir(ResultSet resultSet) throws SQLException{
        int idDocente = resultSet.getInt("idDocente");
        String nombre = resultSet.getString("nombre");
        String fechaInicio = resultSet.getString("fechaInicio");
        String turno = resultSet.getString("turno");
        String horario = resultSet.getString("horario");
        String seccion = resultSet.getString("seccion");
        Curso curso = new Curso(idDocente, nombre, fechaInicio, turno, horario, seccion);
        curso.setIdCurso(resultSet.getInt("idCurso"));
        return curso;
    }

    @Override
    public Curso getOne(Integer id) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Curso curso;
        try{
            statement = connection.prepareStatement(GETONE);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                curso = convertir(resultSet);
            } else {
                throw new DAOException("Registro no encontrado!.");
            }
        } catch (SQLException exception) {
            throw new DAOException("Error en SQL!.", exception);
        } finally {
            Utilidades.close(statement, resultSet);
        }
        return curso;
    }
}
