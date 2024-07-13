package lk.ijse.finalProject.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.finalProject.entity.Books;
import lk.ijse.finalProject.view.tdm.BookTm;
import lk.ijse.finalProject.repository.BookRepo;

import java.sql.SQLException;
import java.util.List;

public class BookFormController  {

    @FXML
    private TableView<BookTm> tblBook;

    @FXML
    private TableColumn<?, ?> colBook_Id;

    @FXML
    private TableColumn<?, ?> colBook_Name;

    @FXML
    private TableColumn<?, ?> colISBN;

    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colPublisher;

    @FXML
    private TableColumn<?, ?> colBook_Type;

    @FXML
    private TableColumn<?, ?> colBook_Qty;

    @FXML
    private TableColumn<?, ?> colBook_Price;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBookName;

    @FXML
    private TextField txtISBN;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtPublisher;

    @FXML
    private TextField txtBookType;

    @FXML
    private TextField txtBookQty;

    @FXML
    private TextField txtBookPrice;

    public void initialize() {
        setCellValueFactory();
        loadAllBooks();
    }

    private void setCellValueFactory() {
        colBook_Id.setCellValueFactory(new PropertyValueFactory<>("Book_id"));
        colBook_Name.setCellValueFactory(new PropertyValueFactory<>("Book_name"));
        colISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("Author"));
        colPublisher.setCellValueFactory(new PropertyValueFactory<>("Publisher"));
        colBook_Type.setCellValueFactory(new PropertyValueFactory<>("Book_Type"));
        colBook_Price.setCellValueFactory(new PropertyValueFactory<>("Book_price"));
        colBook_Qty.setCellValueFactory(new PropertyValueFactory<>("Book_qty"));

    }

    private void loadAllBooks() {
        ObservableList<BookTm> obList = FXCollections.observableArrayList();

        try {
            List<Books> BooksList = BookRepo.getAll();
            for (Books books : BooksList) {
                Books tm = new Books(
                        books.getBook_id(),
                        books.getBook_name(),
                        books.getISBN(),
                        books.getAuthor(),
                        books.getPublisher(),
                        books.getBook_Type(),
                        books.getBook_qty(),
                        books.getBook_price()

                );

                obList.add(tm);
            }

            tblBook.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String Book_id = txtBookId.getText();
        String Book_Name = txtBookName.getText();
        String ISBN = txtISBN.getText();
        String Author = txtAuthor.getText();
        String Publisher = txtPublisher.getText();
        String Book_Type = txtBookType.getText();
        int Book_Qty = Integer.parseInt(txtBookQty.getText());
        double Book_Price = Double.parseDouble(txtBookPrice.getText());

        Books books = new Books(Book_id, Book_Name,ISBN,Author,Publisher,Book_Type,Book_Qty,Book_Price);

        try {
            boolean isSaved = BookRepo.save(books);
            if(isSaved) {
                initialize();
                new Alert(Alert.AlertType.CONFIRMATION, "Item saved!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String Book_id = txtBookId.getText();

        try {
            boolean isDeleted = BookRepo.delete(Book_id);
            if(isDeleted) {
                initialize();
                new Alert(Alert.AlertType.CONFIRMATION, "Book deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String Book_id = txtBookId.getText();
        String Book_Name = txtBookName.getText();
        String ISBN = txtISBN.getText();
        String Author = txtAuthor.getText();
        String Publisher = txtPublisher.getText();
        String Book_Type = txtBookType.getText();
        int Book_Qty = Integer.parseInt(txtBookQty.getText());
        double Book_Price = Double.parseDouble(txtBookPrice.getText());

        Books books = new Books(Book_id, Book_Name,ISBN,Author,Publisher,Book_Type, Book_Qty, Book_Price);


        try {
            boolean isUpdated = BookRepo.update(books);
            if(isUpdated) {
                initialize();
                new Alert(Alert.AlertType.CONFIRMATION, "Book updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

}
