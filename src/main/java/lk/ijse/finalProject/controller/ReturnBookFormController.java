
package lk.ijse.finalProject.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.finalProject.entity.IssueBook;
import lk.ijse.finalProject.entity.PlaceReturnBook;
import lk.ijse.finalProject.entity.ReturnBook;
import lk.ijse.finalProject.view.tdm.ReturnTm;
import lk.ijse.finalProject.repository.*;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReturnBookFormController {

    @FXML
    private ComboBox<String> cmbIssueid;

    @FXML
    private TableColumn<ReturnTm, String> colIssueid;

    @FXML
    private TableColumn<ReturnTm, String> colIssuedate;

    @FXML
    private TableColumn<ReturnTm, String> colMemberid;

    @FXML
    private Label lblIssuedate;

    @FXML
    private Label lblMemberid;

    @FXML
    private AnchorPane pane;

    @FXML
    private TableView<ReturnTm> tblReturnCart;

    private ObservableList<ReturnTm> obList = FXCollections.observableArrayList();

    public void initialize() {
        loadIssueIds();
        initializeTableColumns();
    }

    private void loadIssueIds() {
        ObservableList<String> issueIdList = FXCollections.observableArrayList();
        try {
            List<String> codeList = IssueBookRepo.getIssueIds();
            issueIdList.addAll(codeList);
            cmbIssueid.setItems(issueIdList);
        } catch (SQLException e) {
            showErrorAlert("Error loading issue IDs: " + e.getMessage());
        }
    }

    private void initializeTableColumns() {
        colIssueid.setCellValueFactory(cellData -> cellData.getValue().issueIdProperty());
        colIssuedate.setCellValueFactory(cellData -> cellData.getValue().issueDateProperty());
        colMemberid.setCellValueFactory(cellData -> cellData.getValue().memberIdProperty());
        tblReturnCart.setItems(obList);
    }

    @FXML
    void cmbIssueOnAction(ActionEvent event) {
        String issueId = cmbIssueid.getValue();
        if (issueId != null) {
            loadIssueDetails(issueId);
        }
    }

    private void loadIssueDetails(String issueId) {
        try {
            IssueBook issueBook = IssueBookRepo.searchByIssueId(issueId);
            if (issueBook != null) {
                lblIssuedate.setText(issueBook.getIssue_date().toString());
                lblMemberid.setText(issueBook.getMember_id());
            } else {
                clearIssueDetails();
            }
        } catch (SQLException e) {
            showErrorAlert("Error fetching issue details: " + e.getMessage());
        }
    }

    private void clearIssueDetails() {
        lblIssuedate.setText("");
        lblMemberid.setText("");
    }

    @FXML
    void btnReturnBookOnAction(ActionEvent event) {
        String issueId = cmbIssueid.getValue();
        if (issueId == null) {
            showWarningAlert("Please select an issue ID.");
            return;
        }

        Date issueDate = Date.valueOf(lblIssuedate.getText());
        Date returnDate = Date.valueOf(LocalDate.now());

        ReturnTm returnTm = new ReturnTm(issueId, issueDate.toString(), lblMemberid.getText());
        obList.add(returnTm);

        ReturnBook returnBook;
        returnBook = new ReturnBook(issueId, issueDate, returnDate);
        List<ReturnBook> returnBookList = new ArrayList<>();
        returnBookList.add(returnBook);

        PlaceReturnBook placeReturnBook = new PlaceReturnBook();

        try {
            boolean isPlaced = PlaceReturnBookRepo.PlaceReturnBook(placeReturnBook);
            if (isPlaced) {
                showConfirmationAlert("Book Returned Successfully!");
                clearIssueDetails();
                cmbIssueid.setValue(null);
            } else {
                showWarningAlert("Book Return Unsuccessful!");
            }
        } catch (SQLException e) {
            showErrorAlert("Error returning book: " + e.getMessage());
        }
    }

    private void showConfirmationAlert(String message) {
        new Alert(Alert.AlertType.CONFIRMATION, message).show();
    }

    private void showWarningAlert(String message) {
        new Alert(Alert.AlertType.WARNING, message).show();
    }

    private void showErrorAlert(String message) {
        new Alert(Alert.AlertType.ERROR, message).show();
    }
}
