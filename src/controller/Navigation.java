package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Routes;

import java.io.IOException;

public class Navigation {

        private static AnchorPane pane;
        public static void navigate(Routes route, AnchorPane pane) throws IOException {
            Navigation.pane = pane;
            Navigation.pane.getChildren().clear();
            Stage window = (Stage) Navigation.pane.getScene().getWindow();

            switch (route) {
                case DEPARTMENT:
                    window.setTitle("Department Manage Form");
                    initUI("DepartmentForm.fxml");
                    break;
                case DESIGNATION:
                    window.setTitle("Designation Form");
                    initUI("DesignationForm.fxml");
                    break;
                case EMPLOYEE:
                    window.setTitle("Employee Form");
                    initUI("EmployeeForm.fxml");
                    break;
                case USERACCOUNT:
                    window.setTitle("User Account Form");
                    initUI("UserAccountForm.fxml");
                    break;

                default:
                    new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();
            }
        }
        private static void initUI(String location) throws IOException {
            Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class
                    .getResource("../view/" + location)));
        }
    }

