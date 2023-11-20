package controller;

import db.HrAppFile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.HrAssistantLogin;
import view.tm.HrAssistantLoginTM;

import java.io.IOException;


public class HrAssistantLoginController {
    public Button login;
    public AnchorPane root;
    public Button btnBack;
    public Button btnLogin;
    public TextField txtPassword;
    public TextField txtUserName;
    public AnchorPane hrAssistantRoot;

    public void hrAssistantLoginOnAction(ActionEvent actionEvent)throws IOException {
        ObservableList<HrAssistantLoginTM> observableList= FXCollections.observableArrayList();
        for(HrAssistantLogin hrAssistantLogin: HrAppFile.hrAssistantLoginCredentialsTable){
            if(hrAssistantLogin.getUserName().equals(txtUserName.getText())&& hrAssistantLogin.getPassword().equals(txtPassword.getText())){
                new Alert(Alert.AlertType.INFORMATION, "Successfully Login!").show();
                Stage stage = (Stage) root.getScene().getWindow();
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/HrAssistantForm.fxml"))));
            } else {
                new Alert(Alert.AlertType.WARNING, "User Name or Password Incorrect!").show();

            }
        }


    }

    public void backToHomeOnAction (ActionEvent actionEvent)throws IOException {
        Stage stage=(Stage)root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainForm.fxml"))));
    }
}
