package com.example.btth2_3.model;

public abstract class employee {
    String id;
    String name;


    public employee(String id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public String toString() {
        return "employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


    abstract double tinhLuong();
}
