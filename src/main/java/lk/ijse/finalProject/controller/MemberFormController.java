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
import lk.ijse.finalProject.entity.Member;
import lk.ijse.finalProject.view.tdm.MemberTm;
import lk.ijse.finalProject.repository.MemberRepo;

import java.sql.SQLException;
import java.util.List;

public class MemberFormController {
    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<MemberTm> tblMember;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtaddress;

    @FXML
    private TextField txtcontact;

    public void initialize() {
        setCellValueFactory();
        loadAllMembers();
        addRegex(txtId);
        addRegex(txtName);
        addRegex(txtaddress);
        addRegex(txtcontact);
            // setCellValueFactory();

        }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("Member_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Member_name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Member_address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("Member_contact"));
    }

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

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String Member_id = txtId.getText();
        String Member_Name = txtName.getText();
        String Member_Address = txtaddress.getText();
        String Member_Contact = txtcontact.getText();

        Member member = new Member(Member_id, Member_Name, Member_Address, Member_Contact);

        try {
            boolean isSave = MemberRepo.save(member);
            if (isSave) {
                initialize();
                new Alert(Alert.AlertType.CONFIRMATION, "Member saved!").show();
                clearFields();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String Member_id = txtId.getText();
        String Member_Name = txtName.getText();
        String Member_Address = txtaddress.getText();
        String Member_Contact = txtcontact.getText();

        Member member = new Member(Member_id, Member_Name, Member_Address, Member_Contact);

        try {
            boolean isUpdated = MemberRepo.update(member);
            if(isUpdated) {
                initialize();
                new Alert(Alert.AlertType.CONFIRMATION, "Member updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void txtSearchOnAction(ActionEvent event) throws SQLException {
        String Member_Id = txtId.getText();

        Member member = MemberRepo.searchById(Member_Id);
        if (member   != null) {
            txtId.setText(member.getMember_id());
            txtName.setText(member.getMember_name());
            txtaddress.setText(member.getMember_address());
            txtcontact.setText(member.getMember_contact());
        } else {
            new Alert(Alert.AlertType.INFORMATION, "Member not found!").show();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String Member_id = txtId.getText();

        try {
            boolean isDeleted = MemberRepo.delete(Member_id);
            if(isDeleted) {
                initialize();
                new Alert(Alert.AlertType.CONFIRMATION, "Member deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtaddress.setText("");
        txtcontact.setText("");
    }



    private void addRegex(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (textField == txtId && !newValue.matches("^M.*$")){
                txtId.setStyle(("-fx-focus-color :#f21e0f "));
                txtId.clear();
            }else{
                txtId.setStyle(("-fx-focus-color :#c4c1c0 "));
            }
        });

        textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (textField == txtName && !newValue.matches("^[A-Za-z]+(?:[\s-][A-Za-z]+)*$")){
                txtName.setStyle(("-fx-focus-color :#f21e0f "));
                txtName.clear();
            }else{
                txtName.setStyle(("-fx-focus-color :#c4c1c0 "));
            }
        });

        textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (textField == txtaddress && !newValue.matches("^[\\w\\s\\.,#\\-\\/]+$")){
                txtaddress.setStyle(("-fx-focus-color :#f21e0f "));
                txtaddress.clear();
            }else{
                txtaddress.setStyle(("-fx-focus-color :#c4c1c0 "));
            }
        });

        textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (textField == txtcontact && !newValue.matches("^\\+?[0-9\\s-]+$")){
                txtcontact.setStyle(("-fx-focus-color :#f21e0f "));
                txtcontact.clear();
            }else{
                txtcontact.setStyle(("-fx-focus-color :#c4c1c0 "));
            }
   });

}}

