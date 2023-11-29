package model;

public class UserDt extends Employee  {

    private String userName;
    private String initPassword;



    public UserDt(String userName, String initPassword) {
        this.userName = userName;
        this.initPassword = initPassword;
    }



    public UserDt(String empId, String firstName, String contactNo, String userName, String initPassword) {
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
        return "UserDt{" +
                "userName='" + userName + '\'' +
                ", initPassword='" + initPassword + '\'' +
                '}';
    }
}
