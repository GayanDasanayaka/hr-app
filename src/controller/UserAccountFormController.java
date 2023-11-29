package controller;

import db.HrAppFile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import model.UserDt;

import view.tm.UserDtTm;

import java.io.IOException;
import java.util.Optional;

public class UserAccountFormController {
    public AnchorPane userRoot;
    public Button btnNewDesignation;
    public TextField txtEmployeeID;
    public TextField txtName;
    public TextField txtContactNo;
    public Button btnNewUser;
    public TextField txtUserName;
    public TextField txtInitialPassword;
    public Button btnCreateNewUser;
    public TableView<UserDtTm> tblUserData;
    public TableColumn colEmpId;
    public TableColumn colName;
    public TableColumn colContactNo;
    public TableColumn colUserName;
    public TableColumn colOption;

    private String searchText="";

    public void initialize(){
        colEmpId.setCellValueFactory(new PropertyValueFactory<>("empId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));


        tblUserData.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (null != newValue) {
                setData(newValue);
            }

        });

    }

    private void setData(UserDtTm tm){
        txtEmployeeID.setText(tm.getEmpId());
        txtName.setText(tm.getName());
        txtContactNo.setText(tm.getContactNo());
        txtUserName.setText(tm.getUserName());

    }

    private void searchUsers(String text) {
        ObservableList<UserDtTm> obList = FXCollections.observableArrayList();
        for (UserDt userDt : HrAppFile.userDtTable) {
            if (userDt.getEmpId().contains(text) || userDt.getUserName().contains(text)) {
                Button btn = new Button("Suspend");
                UserDtTm tm = new UserDtTm(
                        userDt.getEmpId(),
                        userDt.getFirstName(), userDt.getContactNo(), userDt.getUserName(), btn);

                obList.add(tm);

                btn.setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure?",
                            ButtonType.YES, ButtonType.NO);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if (buttonType.get() == ButtonType.YES) {
                        boolean isDeleted = HrAppFile.userDtTable.remove(userDt);
                        if (isDeleted) {
                            searchUsers(searchText);
                            new Alert(Alert.AlertType.INFORMATION, "User Suspended!").show();

                        }
                    } else {
                        new Alert(Alert.AlertType.WARNING, "Try Again!").show();
                    }

                });
            }
        }
        tblUserData.setItems(obList);
    }


    public void addNewUserAddOnAction(ActionEvent actionEvent) throws IOException {
        btnCreateNewUser.setText("Save User");
    }

    public void saveNewUserOnAction(ActionEvent actionEvent) throws IOException{
        UserDt userDt = new UserDt(txtEmployeeID.getText(), txtName.getText(), txtContactNo.getText(), txtUserName.getText(), txtInitialPassword.getText());
        if (btnCreateNewUser.getText().equalsIgnoreCase("Save User")) {
            boolean isSaved = HrAppFile.userDtTable.add(userDt);
            if (isSaved) {
                searchUsers(searchText);
                new Alert(Alert.AlertType.INFORMATION, "HR Assistant Saved!").show();


            } else {
                new Alert(Alert.AlertType.WARNING, "Something went wrong!").show();
            }
        }
    }
}

