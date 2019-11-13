package com.example.matka_apuri;

import android.graphics.Bitmap;

public class RecyclerViewDataClass {
    private Bitmap image;
    private boolean close;
    private String name;
    private String info;

    RecyclerViewDataClass(Bitmap image, boolean close, String name, String info) {
        this.image = image;
        this.close = close;
        this.name = name;
        this.info = info;
    }

    public Bitmap getImage() {
        return image;
    }

    public boolean isClose() {
        return close;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }
}
