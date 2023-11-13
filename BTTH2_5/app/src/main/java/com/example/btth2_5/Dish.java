package com.example.btth2_5;

public class Dish {
    String name;
    String thumbnail;
    boolean promotion;


    public Dish(String name, String thumbnail, boolean promotion) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.promotion = promotion;
    }


    public String getName() {
        return name;
    }


    public String getThumbnail() {
        return thumbnail;
    }


    public boolean isPromotion() {
        return promotion;
    }
}
