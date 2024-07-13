package lk.ijse.finalProject.repository;

import lk.ijse.finalProject.db.DbConnection;
import lk.ijse.finalProject.entity.Books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepo {
    public static boolean save(Books books) throws SQLException {
        String sql = "INSERT INTO books VALUES(?, ?, ?, ?,?,?,?,?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, books.getBook_id());
        pstm.setObject(2, books.getBook_name());
        pstm.setObject(3, books.getISBN());
        pstm.setObject(4, books.getAuthor());
        pstm.setObject(5, books.getPublisher());
        pstm.setObject(6, books.getBook_Type());
        pstm.setObject(7, books.getBook_qty());
        pstm.setObject(8, books.getBook_price());


        return pstm.executeUpdate() > 0;
    }

    public static Books searchById(String Book_id) throws SQLException {
        String sql = "SELECT * FROM books WHERE Book_id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, Book_id);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            String Book_Id = resultSet.getString(1);
            String Book_Name = resultSet.getString(2);
            String ISBN = resultSet.getString(3);
            String Author = resultSet.getString(4);
            String Publisher = resultSet.getString(5);
            String Book_Type = resultSet.getString(6);
            int Book_Qty = resultSet.getInt(7);
            double Book_Price = resultSet.getDouble(8);

            Books books = new Books(Book_Id, Book_Name,ISBN,Author,Publisher,Book_Type, Book_Qty,Book_Price);

            return books;
        }

        return null;
    }

    public static boolean update(Books books) throws SQLException {
        String sql = "UPDATE books SET Book_name = ?, ISBN = ?, Author = ?, Publisher = ?,Book_Type = ?,Book_qty = ?, Book_price = ? WHERE Book_id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, books.getBook_name());
        pstm.setObject(2, books.getBook_price());
        pstm.setObject(3, books.getISBN());
        pstm.setObject(4, books.getAuthor());
        pstm.setObject(5, books.getPublisher());
        pstm.setObject(6, books.getBook_Type());
        pstm.setObject(7, books.getBook_qty());
        pstm.setObject(8, books.getBook_id());

        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String Book_Id) throws SQLException {
        String sql = "DELETE FROM books WHERE Book_id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, Book_Id);

        return pstm.executeUpdate() > 0;
    }

    public static List<Books> getAll() throws SQLException {
        String sql = "SELECT * FROM books";

        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<Books> cusList = new ArrayList<>();

        while (resultSet.next()) {
            String Book_id = resultSet.getString(1);
            String Book_name = resultSet.getString(2);
            String ISBN = resultSet.getString(3);
            String Author = resultSet.getString(4);
            String Publisher = resultSet.getString(5);
            String Book_Type = resultSet.getString(6);
            int Book_qty = resultSet.getInt(7);
            double Book_price = resultSet.getDouble(8);


            Books books = new Books(Book_id, Book_name,ISBN,Author,Publisher,Book_Type, Book_qty,Book_price);
            cusList.add(books);
        }
        return cusList;
    }

    public static List<String> getIds() throws SQLException {
        String sql = "SELECT Book_id FROM books";
        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        List<String> idList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            String Book_Id = resultSet.getString(1);
            idList.add(Book_Id);
        }
        return idList;
    }



    public static boolean updateQty(String bookId) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String query = "UPDATE books SET quantity = quantity - 1 WHERE book_id = ?";
        PreparedStatement stm = connection.prepareStatement(query);
        stm.setString(1, bookId);
        return stm.executeUpdate() > 0;
    }

}