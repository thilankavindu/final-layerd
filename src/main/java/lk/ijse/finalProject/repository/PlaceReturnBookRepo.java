package lk.ijse.finalProject.repository;

import lk.ijse.finalProject.db.DbConnection;
import lk.ijse.finalProject.entity.IssueBook_detail;
import lk.ijse.finalProject.entity.PlaceReturnBook;

import java.sql.Connection;
import java.sql.SQLException;

public class PlaceReturnBookRepo {
    public static boolean PlaceReturnBook(PlaceReturnBook pr) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            boolean isIssueBookSaved = ReturnbookRepo.save(pr.getReturnBook());
            if (isIssueBookSaved) {
                boolean allDetailsSaved = true;
                for (IssueBook_detail detail : pr.getOdList()) {
                    boolean isDetailSaved = IssueBookDetailRepo.save(detail);
                    if (!isDetailSaved) {
                        allDetailsSaved = false;
                        break;
                    }
                }

                if (allDetailsSaved) {
                    connection.commit();
                    return true;
                }
            }
            connection.rollback();
            return false;
        } catch (Exception e) {
            connection.rollback();
            throw new RuntimeException(e);
        } finally {
            connection.setAutoCommit(true);
        }
    }
}
