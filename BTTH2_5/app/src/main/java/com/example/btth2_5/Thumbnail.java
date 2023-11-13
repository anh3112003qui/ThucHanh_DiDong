package com.example.btth2_5;

public enum Thumbnail {
    Thumbnail1("Thumbnail 1", R.drawable.first_thumbnail),
    Thumbnail2("Thumbnail 2", R.drawable.second_thumbnail),
    Thumbnail3("Thumbnail 3", R.drawable.third_thumbnail),
    Thumbnail4("Thumbnail 4", R.drawable.fourth_thumbnail);
    private String name;
    private int img;
    Thumbnail(String name, int img) {
        this.name = name;
        this.img = img;
    }
    public String getName() {
        return name;
    }
    public int getImg() {
        return img;
    }
}
