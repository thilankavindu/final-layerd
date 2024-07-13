package lk.ijse.finalProject.dao.custom.impl;

import lk.ijse.finalProject.dao.custom.ReturnDAO;
import lk.ijse.finalProject.entity.ReturnBook;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReturnDAOImpl implements ReturnDAO {
    @Override
    public ArrayList<ReturnBook> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(ReturnBook entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(ReturnBook entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ReturnBook search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
