package view.tm;

import javafx.scene.control.Button;

public class UserDtTm {
    String empId;
    String name;
    String contactNo;
    String userName;
    Button btn;

    public UserDtTm() {
    }

    public UserDtTm(String empId, String name, String contactNo, String userName, Button btn) {
        this.empId = empId;
        this.name = name;
        this.contactNo = contactNo;
        this.userName = userName;
        this.btn = btn;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
