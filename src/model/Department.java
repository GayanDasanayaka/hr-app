package model;

import java.io.Serializable;

public class Department implements Serializable {

    private String depId;
    private String depName;
    private String description;


    public Department(String depId, String depName, String description) {
        this.depId = depId;
        this.depName = depName;
        this.description = description;
    }



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

    @Override
    public String toString() {
        return "Department{" +
                "depId='" + depId + '\'' +
                ", depName='" + depName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
