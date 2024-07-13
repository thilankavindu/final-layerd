package lk.ijse.finalProject.repository;

import lk.ijse.finalProject.db.DbConnection;
import lk.ijse.finalProject.entity.IssueBook_detail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class IssueBookDetailRepo {
    public static boolean save(List<IssueBook_detail> odList) throws SQLException {
        for (IssueBook_detail Id : odList) {
            boolean isSaved = save(Id);
            if(!isSaved) {
                return false;
            }
        }
        return true;
    }

    /*private static boolean save(IssueBook_detail Id) throws SQLException {
        String sql = "INSERT INTO IssueBook_detail VALUES(?, ?)";

        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        pstm.setString(1, Id.getIssue_id());
        pstm.setString(2, Id.getBook_id());


        return pstm.executeUpdate() > 0;    //false ->  |
    }*/


// meka delet karanna
    public static boolean save(IssueBook_detail detail) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String query = "INSERT INTO IssueBook_detail (Issue_id, Book_id) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, detail.getIssue_id());
        statement.setString(2, detail.getBook_id());
        return statement.executeUpdate() > 0;
    }

}

