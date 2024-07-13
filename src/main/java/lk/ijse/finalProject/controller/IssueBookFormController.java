package lk.ijse.finalProject.controller;

import com.jfoenix.controls.JFXDatePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.finalProject.entity.*;
import lk.ijse.finalProject.view.tdm.CartTm;
import lk.ijse.finalProject.repository.BookRepo;
import lk.ijse.finalProject.repository.IssueBookRepo;
import lk.ijse.finalProject.repository.MemberRepo;
import lk.ijse.finalProject.repository.PlaceIssueBookRepo;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IssueBookFormController {
    @FXML
    private Button btnAddToCart;

    @FXML
    private ComboBox<String> cmbMemberid;

    @FXML
    private ComboBox<String> cmbBookid;

    @FXML
    private TableColumn<CartTm, String> colBookid;

    @FXML
    private TableColumn<CartTm, String> colBookname;

    @FXML
    private TableColumn<CartTm, String> colisbn;

    @FXML
    private TableColumn<CartTm, String> colauthor;

    @FXML
    private TableColumn<CartTm, String> colpublisher;

    @FXML
    private TableColumn<CartTm, String> colBooktype;

    @FXML
    private Label lblMemberName;

    @FXML
    private Label lblBookName;

    @FXML
    private Label lblISBN;

    @FXML
    private Label lblAuthor;

    @FXML
    private Label lblIssueId;

    @FXML
    private Label lblPublisher;

    @FXML
    private Label lblBooktype;

    @FXML
    private Label lblIssueDate;

    @FXML
    private JFXDatePicker txtReturndate;

    @FXML
    private AnchorPane pane;

    @FXML
    private TableView<CartTm> tblIssueCart;

    @FXML
    private Label txtQty;

    private ObservableList<CartTm> obList = FXCollections.observableArrayList();

    public void initialize() {

        setDate();
        getCurrentIssueId();
        getMemberIds();
        getBookIds();
        setCellValueFactory();
    }

    private void setCellValueFactory() {
        colBookid.setCellValueFactory(new PropertyValueFactory<>("book_id"));
        colBookname.setCellValueFactory(new PropertyValueFactory<>("book_name"));
        colisbn.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        colauthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colpublisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        colBooktype.setCellValueFactory(new PropertyValueFactory<>("book_type"));
    }

    private void getBookIds() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<String> codeList = BookRepo.getIds();
            obList.addAll(codeList);
            cmbBookid.setItems(obList);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Error loading book IDs: " + e.getMessage()).show();
        }
    }
    private void getMemberIds() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<String> idList = MemberRepo.getIds();
            obList.addAll(idList);
            cmbMemberid.setItems(obList);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Error loading member IDs: " + e.getMessage()).show();
        }
    }
    private void getCurrentIssueId() {
        try {
            String currentId = IssueBookRepo.getCurrentId();
            String nextIssue_id = generateNextIssueId(currentId);
            lblIssueId.setText(nextIssue_id);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Error fetching current issue ID: " + e.getMessage()).show();
        }
    }
    private String generateNextIssueId(String currentId) {
        if(currentId != null) {
            String[] split = currentId.split("O");  //" ", "2"
            int idNum = Integer.parseInt(split[1]);
            return "O" + ++idNum;
        }
        return "O1";
    }

    private void setDate() {
        LocalDate now = LocalDate.now();
        lblIssueDate.setText(String.valueOf(now));
    }

    @FXML
    void btnNewCustomerOnAction(ActionEvent event) {
        // Handle new customer action if needed
    }

    @FXML
    void btnIssueBookOnAction(ActionEvent event) {
        String Issue_id = lblIssueId.getText();
        Date issue_date = Date.valueOf(Date.valueOf(LocalDate.now()).toLocalDate());
        String Member_id = cmbMemberid.getValue();

        var issuebook = new IssueBook(Issue_id, issue_date,Member_id);

        List<IssueBook_detail> odList = new ArrayList<>();

        for (CartTm tm : obList) {
            IssueBook_detail od = new IssueBook_detail(Issue_id, tm.getBook_id());
            odList.add(od);
        }

        PlaceIssueBook pb = new PlaceIssueBook(issuebook, odList);
        try {
            boolean isPlaced = PlaceIssueBookRepo.PlaceIssueBook(pb);
            if (isPlaced) {
                new Alert(Alert.AlertType.CONFIRMATION, "Book Issued!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Book Issued Unsuccessfully!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void cmbMemberOnAction(ActionEvent event) {
        String Member_id = cmbMemberid.getValue();
        try {
            Member member = MemberRepo.searchById(Member_id);
            lblMemberName.setText(member.getMember_name());
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Error fetching member details: " + e.getMessage()).show();
        }
    }

    @FXML
    void cmbBookOnAction(ActionEvent event) {
        String Book_id = cmbBookid.getValue();
        try {
            Books books = BookRepo.searchById(Book_id);
            if (books != null) {
                lblBookName.setText(books.getBook_name());
                lblISBN.setText(books.getISBN());
                lblAuthor.setText(books.getAuthor());
                lblPublisher.setText(books.getPublisher());
                lblBooktype.setText(books.getBook_Type());
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Error fetching book details: " + e.getMessage()).show();
        }
    }

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {
        String Book_id = cmbBookid.getValue();
        try {
            Books books = BookRepo.searchById(Book_id);
            if (books != null) {
                CartTm cartTm = new CartTm(
                        books.getBook_id(),
                        books.getBook_name(),
                        books.getISBN(),
                        books.getAuthor(),
                        books.getPublisher(),
                        books.getBook_Type()
                );
                obList.add(cartTm);
                tblIssueCart.setItems(obList);
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Error adding to cart: " + e.getMessage()).show();
        }
    }

}