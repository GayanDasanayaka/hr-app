package view.tm;

import javafx.scene.control.Button;

public class DesignationTm {
    String desigId;
    String desigName;
    String description;
    Button btn;

    public DesignationTm() {
    }

    public DesignationTm(String desigId, String desigName, String description, Button btn) {
        this.desigId = desigId;
        this.desigName = desigName;
        this.description = description;
        this.btn = btn;
    }

    public String getDesigId() {
        return desigId;
    }

    public void setDesigId(String desigId) {
        this.desigId = desigId;
    }

    public String getDesigName() {
        return desigName;
    }

    public void setDesigName(String desigName) {
        this.desigName = desigName;
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
}
