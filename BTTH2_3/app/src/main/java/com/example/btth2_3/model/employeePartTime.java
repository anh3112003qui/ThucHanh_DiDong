package com.example.btth2_3.model;

public class employeePartTime extends employee{
    public employeePartTime(String id, String name) {
        super(id, name);
    }
    @Override
    public double tinhLuong() {return 150d;}
    @Override
    public String toString() {return super.toString() + "-->PartTime = " + tinhLuong();}
}

