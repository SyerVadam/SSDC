package DAO;

import java.util.List;

public interface DAO<modelClass, dataType> {
    void insert(modelClass obj) throws DAOException;

    void update(modelClass obj) throws DAOException;

    void delete(modelClass obj) throws DAOException;

    modelClass getOne(dataType id) throws DAOException;
}
