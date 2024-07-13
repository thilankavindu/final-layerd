package lk.ijse.finalProject.repository;

import lk.ijse.finalProject.db.DbConnection;
import lk.ijse.finalProject.entity.IssueBook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IssueBookRepo {
    public static String getCurrentId() throws SQLException {
        String sql = "SELECT Issue_id FROM IssueBook ORDER BY Issue_id DESC LIMIT 1";
        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            String Issue_id = resultSet.getString(1);
            return Issue_id;
        }
        return null;
    }

    /*public static boolean save(IssueBook issueBook) throws SQLException {
        String sql = "INSERT INTO IssueBook VALUES(?, ?, ?)";
        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        pstm.setString(1, issueBook.getIssue_id());
        pstm.setDate(2, issueBook.getIssue_date());
        pstm.setString(3, issueBook.getMember_id());



        return pstm.executeUpdate() > 0;
    }*/
    public static boolean save(IssueBook issueBook) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String query = "INSERT INTO IssueBook (Issue_id, issue_date, Member_id) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, issueBook.getIssue_id());
        statement.setDate(2, issueBook.getIssue_date());
        statement.setString(3, issueBook.getMember_id());
        return statement.executeUpdate() > 0;
    }

    public static List<String> getIssueIds() throws SQLException {
        String sql = "SELECT issue_id FROM IssueBook";
        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        List<String> idList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            String Issue_Id = resultSet.getString(1);
            idList.add(Issue_Id);
        }
        return idList;
    }







    public static IssueBook searchByIssueId(String issue_id) throws SQLException {
        String sql = "SELECT * FROM issuebook WHERE issue_id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, issue_id);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            issue_id = resultSet.getString(1);
            Date issue_date = Date.valueOf(resultSet.getString(2));
            String member_id = resultSet.getString(3);


            IssueBook issueBook = new IssueBook(issue_id, issue_date,member_id);

            return issueBook;
        }

        return null;
    }

}