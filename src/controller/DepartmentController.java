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
import view.tm.DepartmentTm;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Optional;

public class DepartmentController {
    public AnchorPane root;
    public TextField departmentId;
    public TextField departmentName;
    public TextField description;
    public Button btnSave;
    public Button btnAddDep;
    public TableView<DepartmentTm> tblDepData;
    public TableColumn colDepId;

    public TableColumn colName;
    public TableColumn colDesc;
    public TableColumn colOption;
    public TextField txtSearch;

    String filePath="D:\\Gayan\\ICBT\\HND-CSE\\Semester 2\\OOP\\hr-app\\src\\Department.ser";



    private String searchText = "";
    private Object Department;
    private Object ArrayList;

    public void initialize() {
        colDepId.setCellValueFactory(new PropertyValueFactory<>("DepId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("DepName"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));
        searchDepartment(searchText);

        tblDepData.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (null != newValue) {
                setData(newValue);
            }});
        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            searchText = newValue;
            searchDepartment(searchText);
        });

    }
    private void setData(DepartmentTm tm) {

        departmentId.setText(tm.getDepId());
        departmentName.setText(tm.getDepName());
        description.setText(tm.getDescription());
        btnSave.setText("Update");

    }

    private void searchDepartment(String text) {
        ObservableList<DepartmentTm> obList = FXCollections.observableArrayList();
        for (Department dep : HrAppFile.departmentTable) {
            if (dep.getDepName().contains(text) || dep.getDepId().contains(text)) {
                Button btn = new Button("Delete");
                DepartmentTm tm = new DepartmentTm(
                        dep.getDepId(),
                        dep.getDepName(),
                        dep.getDescription(), btn
                );

                obList.add(tm);

                btn.setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure?",
                            ButtonType.YES, ButtonType.NO);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if (buttonType.get() == ButtonType.YES) {
                        boolean isDeleted = HrAppFile.departmentTable.remove(dep);
                        if (isDeleted) {
                            searchDepartment(searchText);
                            new Alert(Alert.AlertType.INFORMATION, "Department Deleted!").show();

                        }
                    } else {
                        new Alert(Alert.AlertType.WARNING, "Try Again!").show();
                    }});
            }
        }
        tblDepData.setItems(obList);
    }

    public void departmentSaveOnAction(ActionEvent actionEvent) throws IOException {

        Department department = new Department(departmentId.getText(), departmentName.getText(), description.getText());


        if (btnSave.getText().equalsIgnoreCase("Save")) {
            //ArrayList<Department>departmentTable=new ArrayList<Department>();
            //boolean isSaved=WriteFile.writeFile(filePath,departmentTable);
            boolean isSaved = HrAppFile.departmentTable.add(department);

            if (isSaved) {
                searchDepartment(searchText);
                new Alert(Alert.AlertType.INFORMATION, "Department Saved!").show();
                clearField();

            } else {
                new Alert(Alert.AlertType.WARNING, "Something went wrong!").show();
            }

        } else {
            for (int i = 0; i < HrAppFile.departmentTable.size(); i++) {
                if (departmentId.getText().equalsIgnoreCase(HrAppFile.departmentTable.get(i).getDepId())) {
                    HrAppFile.departmentTable.get(i).setDepName(departmentName.getText());
                    HrAppFile.departmentTable.get(i).setDescription(description.getText());
                    searchDepartment(searchText);
                    new Alert(Alert.AlertType.INFORMATION, "Department Updated!").show();
                    clearField();

                }
            }
        }
    }
    public void departmentAddOnAction(ActionEvent actionEvent) {
        btnSave.setText("Save");
    }

    public void bacToMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/HrManagerForm.fxml"))));
    }

    private void clearField() {
        departmentId.clear();
        departmentName.clear();
        description.clear();
    }


}
