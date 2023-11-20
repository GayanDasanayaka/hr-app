package model;

public class UserDt {
    String empId;
    String name;
    String contactNo;
    String userName;
    String initPassword;

    public UserDt() {
    }

    public UserDt(String empId, String name, String contactNo, String userName, String initPassword) {
        this.empId = empId;
        this.name = name;
        this.contactNo = contactNo;
        this.userName = userName;
        this.initPassword = initPassword;
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

    public String getInitPassword() {
        return initPassword;
    }

    public void setInitPassword(String initPassword) {
        this.initPassword = initPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", userName='" + userName + '\'' +
                ", initPassword='" + initPassword + '\'' +
                '}';
    }
}
