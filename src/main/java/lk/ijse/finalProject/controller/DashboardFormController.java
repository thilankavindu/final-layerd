package lk.ijse.finalProject.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.finalProject.db.DbConnection;
import lk.ijse.finalProject.entity.Books;
import lk.ijse.finalProject.entity.Member;
import lk.ijse.finalProject.view.tdm.BookTm;
import lk.ijse.finalProject.view.tdm.MemberTm;
import lk.ijse.finalProject.repository.BookRepo;
import lk.ijse.finalProject.repository.MemberRepo;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DashboardFormController {
    public AnchorPane rootNode;
    public AnchorPane smallrootNode;

    @FXML
    private TableView<BookTm> tblBook;

    @FXML
    private TableColumn<?, ?> colBook_Id;

    @FXML
    private TableColumn<?, ?> colBook_Name;

    @FXML
    private TableColumn<?, ?> colBook_Qty;

    @FXML
    private TableColumn<?, ?> colISBN;

    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colPublisher;

    @FXML
    private TableColumn<?, ?> colBook_Type;

    @FXML
    private TableColumn<?, ?> colBook_Price;

    public Label lblMemberCount;
    private int memberCount;

    public Label lblBookCount;
    private int bookCount;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableView<MemberTm> tblMember;


    public void initialize() {
        setCellValueFactory();
        loadAllBooks();
        loadAllMembers();
        try {
            memberCount = getMemberCount();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
        setMemberCount(memberCount);

        try {
            bookCount = getBookCount();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
        setBookCount(bookCount);
    }


    private void setMemberCount(int memberCount) {
        lblMemberCount.setText(String.valueOf(memberCount));
    }

    private int getMemberCount() throws SQLException {
        String sql = "SELECT COUNT(*) AS member_count FROM member";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        if(resultSet.next()) {
            return resultSet.getInt("member_count");
        }
        return 0;
    }

    private void setBookCount(int bookCount) {lblBookCount.setText(String.valueOf(bookCount));
    }

    private int getBookCount() throws SQLException {
        String sql = "SELECT COUNT(*) AS book_count FROM books";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        if(resultSet.next()) {
            return resultSet.getInt("book_count");
        }
        return 0;
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

        colId.setCellValueFactory(new PropertyValueFactory<>("Member_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Member_name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Member_address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("Member_contact"));

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

    /*private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("Member_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Member_name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Member_address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("Member_contact"));
    }*/

    private void loadAllMembers() {
        ObservableList<MemberTm> obList = FXCollections.observableArrayList();

        try {
            List<Member> MemberList = MemberRepo.getAll();
            for (Member member : MemberList) {
                Member tm = new Member(
                        member.getMember_id(),
                        member.getMember_name(),
                        member.getMember_address(),
                        member.getMember_contact()
                );

                obList.add(tm);
            }

            tblMember.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



  /*  public void initialize() {
        setCellValueFactory();
        loadAllBooks();
    }




    private void setCellValueFactory() {
        colBook_Id.setCellValueFactory(new PropertyValueFactory<>("Book_id"));
        colBook_Name.setCellValueFactory(new PropertyValueFactory<>("Book_name"));
        colBook_Qty.setCellValueFactory(new PropertyValueFactory<>("Book_qty"));
        colBook_Price.setCellValueFactory(new PropertyValueFactory<>("Book_price"));
    }

    private void loadAllBooks() {
        ObservableList<BookTm> obList = FXCollections.observableArrayList();

        try {
            List<Books> BooksList = BookRepo.getAll();
            for (Books books : BooksList) {
                Books tm = new Books(
                        books.getBook_id(),
                        books.getBook_name(),
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
*/


    @FXML
    void btnManageBooksOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Managebook.fxml"));
        Parent load = fxmlLoader.load();
        smallrootNode.getChildren().clear();
        smallrootNode.getChildren().add(load);
    }

    @FXML
    void btnManageMembersOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/ManageMembers.fxml"));
        Parent load = fxmlLoader.load();
        smallrootNode.getChildren().clear();
        smallrootNode.getChildren().add(load);
    }

    @FXML
    void btnManageIssueBooksOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/IssueBook.fxml"));
        Parent load = fxmlLoader.load();
        smallrootNode.getChildren().clear();
        smallrootNode.getChildren().add(load);
    }
    @FXML
    void btnManageReturnBooksOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/ReturnBook.fxml"));
        Parent load = fxmlLoader.load();
        smallrootNode.getChildren().clear();
        smallrootNode.getChildren().add(load);
    }

  /* @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/dashboard.fxml"));
        Parent load = fxmlLoader.load();
        smallrootNode.getChildren().clear();
        smallrootNode.getChildren().add(load);
    }*/

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"));
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard Form");
        stage.centerOnScreen();

    }


    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/loginForm.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login Form");
    }

    public void btnReportOnAction(ActionEvent actionEvent)throws SQLException, JRException {
        JasperDesign jasperDesign = JRXmlLoader.load("src/main/resources/Report/Bill.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);


        JasperPrint jasperPrint =
                JasperFillManager.fillReport(jasperReport, null, DbConnection.getInstance().getConnection());
        JasperViewer.viewReport(jasperPrint,false);


    }
}
