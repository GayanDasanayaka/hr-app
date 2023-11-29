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
import model.Department;
import model.Designation;

import model.Employee;
import view.tm.EmpployeeTm;

import java.io.IOException;
import java.util.Optional;

public class EmployeeFormController {

    public AnchorPane root;
    public TextField txtEmployeeId;
    public TextField txtfirstName;
    public Button btnSave;
    public Button btnNewEmployee;
    public TableView<EmpployeeTm> tblEmployeeDetail;
    public TableColumn colEmployeeId;
    public TableColumn colFName;
    public TableColumn colLName;
    public TableColumn colAddress;
    public TableColumn colContactNo;
    public TableColumn colDob;
    public TableColumn colDepartment;
    public TableColumn colDesignation;
    public TableColumn colOption;
    public TextField txtSearch;
    public TextField txtLastName;
    public TextField txtDob;
    public TextField txtContactNo;
    public TextField txtAddress;
    public ComboBox<String> cmbDepartment;
    public ComboBox<String> cmbDesignation;
    public AnchorPane employeeRoot;

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
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));

        searchEmployee(searchText);
        tblEmployeeDetail.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (null != newValue) {
                setEmployeeData(newValue);
            }
        });
        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            searchText = newValue;
            searchEmployee(searchText);
        });

        loadAllDepartment();
        loadAllDesignation();
    }

    private void setEmployeeData(EmpployeeTm tm) {
        txtEmployeeId.setText(tm.getEmpId());
        txtfirstName.setText(tm.getFirstName());
        txtLastName.setText(tm.getLastName());
        txtAddress.setText(tm.getAddress());
        txtContactNo.setText(tm.getContactNo());
        txtDob.setText(tm.getDob());
        cmbDesignation.setValue(tm.getDesignation());
        cmbDepartment.setValue(tm.getDepartment());
        btnSave.setText("Update");

    }

    private void loadAllDepartment() {
        for (Department dep : HrAppFile.departmentTable) {
            cmbDepartment.getItems().add(dep.getDepName());
        }
    }

    private void loadAllDesignation() {
        for (Designation desig : HrAppFile.designationsTable) {
            cmbDesignation.getItems().add(desig.getDesigName());
        }
    }

    private void searchEmployee(String text) {
        ObservableList<EmpployeeTm> obList = FXCollections.observableArrayList();
        for (Employee employee : HrAppFile.employeeTable) {
            if (employee.getFirstName().contains(text) || employee.getEmpId().contains(text) || employee.getContactNo().contains(text)) {
                Button btn = new Button("Delete");
                EmpployeeTm tm = new EmpployeeTm(
                        employee.getEmpId(),
                        employee.getFirstName(), employee.getLastName(),
                        employee.getAddress(), employee.getContactNo(), employee.getDob(), employee.getDepartment(), employee.getDesignation(), btn);
                obList.add(tm);

                btn.setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure?",
                            ButtonType.YES, ButtonType.NO);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if (buttonType.get() == ButtonType.YES) {
                        boolean isDeleted = HrAppFile.employeeTable.remove(employee);
                        if (isDeleted) {
                            searchEmployee(searchText);
                            new Alert(Alert.AlertType.INFORMATION, "Employee Deleted!").show();

                        }
                    } else {
                        new Alert(Alert.AlertType.WARNING, "Try Again!").show();
                    }
                });
            }
        }
        tblEmployeeDetail.setItems(obList);
    }
    public void employeeSaveOnAction(ActionEvent actionEvent) {
        Employee emp = new Employee(txtEmployeeId.getText(), txtfirstName.getText(),
                txtLastName.getText(), txtAddress.getText(), txtContactNo.getText(),
                txtDob.getText(), cmbDepartment.getValue(), cmbDesignation.getValue());


        if (btnSave.getText().equalsIgnoreCase("Save")) {
            boolean isSaved = HrAppFile.employeeTable.add(emp);
            if (isSaved) {
                searchEmployee(searchText);
                new Alert(Alert.AlertType.INFORMATION, "Employee Saved!").show();
                clearField();

            } else {
                new Alert(Alert.AlertType.WARNING, "Something went wrong!").show();
            }

        } else {
            for (int i = 0; i < HrAppFile.employeeTable.size(); i++) {
                if (txtEmployeeId.getText().equalsIgnoreCase(HrAppFile.employeeTable.get(i).getEmpId())) {
                    HrAppFile.employeeTable.get(i).setFirstName(txtfirstName.getText());
                    HrAppFile.employeeTable.get(i).setLastName(txtLastName.getText());
                    HrAppFile.employeeTable.get(i).setAddress(txtAddress.getText());
                    HrAppFile.employeeTable.get(i).setContactNo(txtContactNo.getText());
                    HrAppFile.employeeTable.get(i).setDob(txtDob.getText());
                    HrAppFile.employeeTable.get(i).setDepartment(cmbDepartment.getValue());
                    HrAppFile.employeeTable.get(i).setDesignation(cmbDesignation.getValue());

                    searchEmployee(searchText);
                    new Alert(Alert.AlertType.INFORMATION, "Employee Updated!").show();
                    clearField();

                }
            }
        }
    }
    public void addNewEmployeeOnAction(ActionEvent actionEvent) {

        btnSave.setText("Save");
    }

    public void backToMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/HrManagerForm.fxml"))));
    }

    private void clearField() {
        txtEmployeeId.clear();
        txtfirstName.clear();
        txtLastName.clear();
        txtAddress.clear();
        txtDob.clear();
        txtContactNo.clear();

    }
}
