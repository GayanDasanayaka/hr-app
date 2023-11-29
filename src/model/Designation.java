package model;

public class Designation {
    private String desigId;
    private String desigName;
    private String description;


    public Designation() {
    }

    public Designation(String desigId, String desigName, String description) {
        this.desigId = desigId;
        this.desigName = desigName;
        this.description = description;
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

    @Override
    public String toString() {
        return "Designation{" +
                "desigId='" + desigId + '\'' +
                ", desigName='" + desigName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
