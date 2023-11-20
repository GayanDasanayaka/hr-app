package view.tm;

import javafx.scene.control.Button;

public class DepartmentTm {
    private String depId;
    private String depName;
    private String description;
    private Button btn;

    public DepartmentTm(String depId, String depName, String description, Button btn) {
        this.depId = depId;
        this.depName = depName;
        this.description = description;
        this.btn = btn;
    }

    public DepartmentTm() {
    }

    public DepartmentTm(String depId) {this.depId = depId;}

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "DepartmentTm{" +
                "depId='" + depId + '\'' +
                ", depName='" + depName + '\'' +
                ", description='" + description + '\'' +
                ", btn=" + btn +
                '}';
    }
}
