package lk.ijse.finalProject.repository;

import lk.ijse.finalProject.db.DbConnection;
import lk.ijse.finalProject.entity.PlaceIssueBook;
import lk.ijse.finalProject.entity.IssueBook_detail;

import java.sql.Connection;
import java.sql.SQLException;

public class PlaceIssueBookRepo {
    public static boolean PlaceIssueBook(PlaceIssueBook pb) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            boolean isIssueBookSaved = IssueBookRepo.save(pb.getIssueBook());
            if (isIssueBookSaved) {
                boolean allDetailsSaved = true;
                for (IssueBook_detail detail : pb.getOdList()) {
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
