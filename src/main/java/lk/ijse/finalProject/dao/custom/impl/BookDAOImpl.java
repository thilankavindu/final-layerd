package lk.ijse.finalProject.dao.custom.impl;

import lk.ijse.finalProject.dao.custom.BookDAO;
import lk.ijse.finalProject.entity.Books;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAOImpl implements BookDAO {
    @Override
    public ArrayList<Books> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(Books entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Books entity) throws SQLException, ClassNotFoundException {
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
    public Books search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
