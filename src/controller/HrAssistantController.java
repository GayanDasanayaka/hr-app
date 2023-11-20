package controller;

import db.HrAppFile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Employee;
import view.tm.EmpployeeTm;

import java.io.IOException;
import java.util.Optional;

public class HrAssistantController {

    public TextField txtEmployeeId;
    public TextField txtfirstName;
    public TextField txtDob;
    public TextField txtDepartment;
    public TextField txtDesignation;
    public Button btnSearch;
    public TableView<EmpployeeTm> tblEmployeeDetail;
    public TableColumn colEmployeeId;
    public TableColumn colFName;
    public TableColumn colLName;
    public TableColumn colAddress;
    public TableColumn colContactNo;
    public TableColumn colDob;
    public TableColumn colDepartment;
    public TableColumn colDesignation;
    public AnchorPane root;
    public Button btnBack;
    private String searchText = "";


    public void initialize() {
        colEmployeeId.setCellValueFactory(new PropertyValueFactory<>("empId"));
        colFName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));
        colDesignation.setCellValueFactory(new PropertyValueFactory<>("designation"));

        searchEmployee(searchText);




    }
    private void setEmployeeData(EmpployeeTm tm){
       /* colEmployeeId.setText(tm.getEmpId());
        colFName.setText(tm.getFirstName());
        colLName.setText(tm.getLastName());
        colAddress.setText(tm.getAddress());
        colContactNo.setText(tm.getContactNo());
        colDob.setText(tm.getDob());
        colDepartment.setText(tm.getDepartment());
        colDesignation.setText(tm.getDesignation());*/

    }





    private void searchEmployee(String text) {

    ObservableList<EmpployeeTm> obList = FXCollections.observableArrayList();
        for (Employee employee : HrAppFile.employeeTable) {
        if (employee.getFirstName().contains(text) || employee.getEmpId().contains(text) ) {
            Button btn = new Button("Select");
            EmpployeeTm tm = new EmpployeeTm(
                    employee.getEmpId(),
                    employee.getFirstName(), employee.getLastName(),
                    employee.getAddress(), employee.getContactNo(), employee.getDob(), employee.getDepartment(), employee.getDesignation(), btn);


            obList.add(tm);


        }
    }
        tblEmployeeDetail.setItems(obList);
}

    public void employeeSearchOnAction(ActionEvent actionEvent) {





    }

    public void backToHomeOnAction(ActionEvent actionEvent)throws IOException {
        Stage stage=(Stage)root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainForm.fxml"))));
    }
}
