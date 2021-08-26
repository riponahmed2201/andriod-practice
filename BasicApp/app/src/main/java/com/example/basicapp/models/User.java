package com.example.basicapp.models;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String isVaccinated;
    private String areaName;

    public User(String name, String isVaccinated, String areaName) {
        this.name = name;
        this.isVaccinated = isVaccinated;
        this.areaName = areaName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsVaccinated() {
        return isVaccinated;
    }

    public void setIsVaccinated(String isVaccinated) {
        this.isVaccinated = isVaccinated;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
