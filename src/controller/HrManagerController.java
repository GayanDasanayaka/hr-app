package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Routes;

import java.io.IOException;

public class HrManagerController {
    public AnchorPane root;
    public Button btnDepartment;
    public Button btnEmployee;
    public Button btnUserAccount;
    public Button btnDesignation;
    public Button btnSave;
    public TextField txtSearch;
    public TextField departmentId;
    public TableView tblDepData;
    public TableColumn colDepId;
    public TableColumn colName;
    public TableColumn colDesc;
    public TableColumn colOption;
    public Button btnAddDep;
    public TextField departmentName;
    public TextField description;
    public AnchorPane departmentRoot;
    public VBox borderPane;

    public void bacToMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainForm.fxml"))));

    }

    public void departmentOnAction(ActionEvent actionEvent) throws IOException{
        Navigation.navigate(Routes.DEPARTMENT,departmentRoot);

    }

    public void employeeOnAction(ActionEvent actionEvent)throws IOException {
        Navigation.navigate(Routes.EMPLOYEE,departmentRoot);
    }

    public void userAccountOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERACCOUNT,departmentRoot);
    }

    public void designationOnAction(ActionEvent actionEvent)throws IOException {

        Navigation.navigate(Routes.DESIGNATION,departmentRoot);
    }


    public void departmentAddOnAction(ActionEvent actionEvent) {
    }

    public void departmentSaveOnAction(ActionEvent actionEvent) {
    }
}
