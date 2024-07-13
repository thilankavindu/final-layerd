package lk.ijse.finalProject.repository;

import lk.ijse.finalProject.db.DbConnection;
import lk.ijse.finalProject.entity.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberRepo {
    public static boolean save(Member member) throws SQLException {
        String sql = "INSERT INTO member VALUES(?, ?, ?, ?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, member.getMember_id());
        pstm.setObject(2, member.getMember_name());
        pstm.setObject(3, member.getMember_address());
        pstm.setObject(4, member.getMember_contact());

        return pstm.executeUpdate() > 0;
    }

    public static Member searchById(String id) throws SQLException {
        String sql = "SELECT * FROM member WHERE Member_id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            String Member_Id = resultSet.getString(1);
            String Member_Name = resultSet.getString(2);
            String Member_Address = resultSet.getString(3);
            String Member_Contact = resultSet.getString(4);

            Member member = new Member(Member_Id, Member_Name, Member_Address, Member_Contact);

            return member;
        }

        return null;
    }

    public static boolean update(Member member  ) throws SQLException {
        String sql = "UPDATE member SET Member_Name = ?, Member_Address = ?, Member_Contact = ? WHERE Member_Id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, member.getMember_name());
        pstm.setObject(2, member.getMember_address());
        pstm.setObject(3, member.getMember_contact());
        pstm.setObject(4, member.getMember_id());

        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String Member_Id) throws SQLException {
        String sql = "DELETE FROM member WHERE Member_id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, Member_Id);

        return pstm.executeUpdate() > 0;
    }

    public static List<Member> getAll() throws SQLException {
        String sql = "SELECT * FROM member";

        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<Member> cusList = new ArrayList<>();

        while (resultSet.next()) {
            String Member_Id = resultSet.getString(1);
            String Member_Name = resultSet.getString(2);
            String Member_Address = resultSet.getString(3);
            String Member_Contact = resultSet.getString(4);

            Member member = new Member(Member_Id, Member_Name, Member_Address, Member_Contact);
            cusList.add(member);
        }
        return cusList;
    }

    public static List<String> getIds() throws SQLException {
        String sql = "SELECT Member_id FROM member";
        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        List<String> idList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            String Member_Id = resultSet.getString(1);
            idList.add(Member_Id);
        }
        return idList;
    }
}

