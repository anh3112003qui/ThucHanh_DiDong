package com.example.btth2_4;

public class employee {
    String ID;
    String name;
    boolean isManager;
    public employee(String ID, String name, boolean isManager) {
        this.ID = ID;
        this.name = name;
        this.isManager = isManager;
    }
    public String getFullName(){
        return name;
    }
    public boolean isManager() {
        return isManager;
    }
}
