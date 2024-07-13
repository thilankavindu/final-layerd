package lk.ijse.finalProject.repository;

import lk.ijse.finalProject.db.DbConnection;
import lk.ijse.finalProject.entity.ReturnBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReturnbookRepo {
    public static boolean save(ReturnBook returnBook) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String query = "INSERT INTO ReturnBook (Issue_id, issue_date, Member_id,Return_date) VALUES (?, ?, ?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, ReturnBook.getIssue_id());
        statement.setDate(2, ReturnBook.getIssue_date());
        statement.setDate(3, ReturnBook.getReturn_date());
        statement.setString(4, ReturnBook.getMember_id());

        return statement.executeUpdate() > 0;
    }
}
