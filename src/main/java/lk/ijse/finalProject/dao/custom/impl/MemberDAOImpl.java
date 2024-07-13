package lk.ijse.finalProject.dao.custom.impl;

import lk.ijse.finalProject.dao.custom.MemberDAO;
import lk.ijse.finalProject.entity.Member;

import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAOImpl implements MemberDAO {
    @Override
    public ArrayList<Member> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(Member entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Member entity) throws SQLException, ClassNotFoundException {
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
    public Member search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
