package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Routes;


import java.io.IOException;

public class HrManagerLoginController {
    public TextField userName;
    public TextField password;
    public Button login;
    public AnchorPane root;
    public AnchorPane hrManagerRoot;
    public Button btnBack;
    public Button txtLogin;
    public TextField txtPassword;
    public TextField txtUserName;

    public void hrManagerLoginOnAction(ActionEvent actionEvent)throws IOException {

        if(txtUserName.getText().equals("gayan.mgr@thetech.lk") && txtPassword.getText().equals("gay@123")) {
            new Alert(Alert.AlertType.INFORMATION, "Successfully Login!").show();
                Stage stage = (Stage) root.getScene().getWindow();
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/HrManagerForm.fxml"))));


            } else {
                new Alert(Alert.AlertType.WARNING, "User Name or Password Incorrect!").show();
            }
        }


    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException{
        Stage stage=(Stage)root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainForm.fxml"))));
    }
}
