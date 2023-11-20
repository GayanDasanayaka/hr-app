package view.tm;

public class HrAssistantLoginTM {
    String userName;
    String password;

    public HrAssistantLoginTM() {
    }

    public HrAssistantLoginTM(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
