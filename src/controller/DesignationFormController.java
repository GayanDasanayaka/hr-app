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
import model.Designation;
import view.tm.DesignationTm;

import java.io.IOException;
import java.util.Optional;


public class DesignationFormController {
    public AnchorPane root;
    public TextField txtDesignationId;
    public TextField txtDesignationName;
    public TextField txtDescription;
    public Button btnSave;
    public Button btnNewDesignation;
    public TableView<DesignationTm> tblDesignationData;
    public TableColumn colDesignationId;
    public TableColumn colName;
    public TableColumn colDesc;
    public TableColumn colOption;
    public TextField txtSearch;

    private String searchText="";

    public   void initialize (){
        colDesignationId.setCellValueFactory(new PropertyValueFactory<>("desigId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("desigName"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));

        searchDesignation(searchText);

        tblDesignationData.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue!=null){
                setData(newValue);

            }
        });

        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            searchText=newValue;
            searchDesignation(searchText);
        });



    }
    private void setData(DesignationTm tm){
        txtDesignationId.setText(tm.getDesigId());
        txtDesignationName.setText(tm.getDesigName());
        txtDescription.setText(tm.getDescription());
        btnSave.setText("Update");
    }


    private void searchDesignation(String text){
        ObservableList<DesignationTm>oblist= FXCollections.observableArrayList();
        for(Designation designation:HrAppFile.designationsTable){
            if(designation.getDesigName().contains(text) || designation.getDesigId().contains(text)){
              Button btn=new Button("Delete");
              DesignationTm tm=new DesignationTm(
                      designation.getDesigId(),
                      designation.getDesigName(),
                      designation.getDescription(),btn
              );
              oblist.add(tm);

              btn.setOnAction(event -> {
                  Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure?",
                          ButtonType.YES, ButtonType.NO);
                  Optional<ButtonType> buttonType = alert.showAndWait();
                  if (buttonType.get() == ButtonType.YES) {
                      boolean isDeleted = HrAppFile.departmentTable.remove(designation);
                      if (isDeleted) {
                          searchDesignation(searchText);
                          new Alert(Alert.AlertType.INFORMATION, "Department Deleted!").show();

                      }
                  } else {
                      new Alert(Alert.AlertType.WARNING, "Try Again!").show();
                  }


              });


            }
        }
        tblDesignationData.setItems(oblist);
    }

    public void addNewDesignationAddOnAction(ActionEvent actionEvent) {

        btnSave.setText("Save");
    }

    public void designationSaveOnAction(ActionEvent actionEvent) {
        Designation designation = new Designation(txtDesignationId.getText(),
                txtDesignationName.getText(), txtDescription.getText());
        if (btnSave.getText().equalsIgnoreCase("Save")) {
            boolean isSaved = HrAppFile.designationsTable.add(designation);
            if (isSaved) {
                searchDesignation(searchText);
                new Alert(Alert.AlertType.INFORMATION, "Designation Saved!").show();
                clearField();

            } else {
                new Alert(Alert.AlertType.WARNING, "Something went wrong!").show();

            }
        } else {
            for (int i = 0; i < HrAppFile.designationsTable.size(); i++) {
                if(txtDesignationId.getText().equalsIgnoreCase(HrAppFile.designationsTable.get(i).getDesigId())){
                    HrAppFile.designationsTable.get(i).setDesigName(txtDesignationName.getText());
                    HrAppFile.designationsTable.get(i).setDescription(txtDescription.getText());
                    searchDesignation(searchText);
                    new Alert(Alert.AlertType.INFORMATION, "Customer Updated!").show();
                    clearField();
                }
            }
        }
    }

    public void backToMainPageOnAction(ActionEvent actionEvent)throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/HrManagerForm.fxml"))));
    }
    private void clearField() {
        txtDesignationId.clear();
        txtDesignationName.clear();
        txtDescription.clear();
    }
}
