package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFormController {
    public AnchorPane root;
    public Button hrManager;
    public Button hrAssistant;
    public AnchorPane hrManagerRoot;
    public TextField userName;
    public TextField password;
    public Button login;
    public Button btnHrAssistant;
    public Button btnHrManager;
    public TextField txtUserName;
    public TextField txtPassword;
    public Button btnLogin;

    public void hrAssistantOnAction(ActionEvent actionEvent)throws IOException {
        Stage stage=(Stage)root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/HrAssistantLoginForm.fxml"))));


    }

    public void hrManagerOnAction(ActionEvent actionEvent)throws IOException  {
        Stage stage=(Stage)hrManagerRoot.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/HrManagerLoginForm.fxml"))));
    }

    public void hrManagerLoginOnAction(ActionEvent actionEvent) {
    }
}
