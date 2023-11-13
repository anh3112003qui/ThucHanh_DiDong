package com.example.btth2_3.model;

public class employeeFullTime extends employee{
    public employeeFullTime(String id, String name) {
        super(id, name);
    }


    @Override
    public double tinhLuong() {return 500d;}
    @Override
    public String toString() {return super.toString()+ "-->Fulltime = " + tinhLuong();}
}

