package com.example.matka_apuri;

import android.graphics.Bitmap;

public class RecyclerViewDataClass {
    private Bitmap image;
    private boolean close;
    private String name;
    private String weather;
    private String distance;

    RecyclerViewDataClass(Bitmap image, boolean close, String name, String weather, String distance) {
        this.image = image;
        this.close = close;
        this.name = name;
        this.weather = weather;
        this.distance = distance;
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

    public String getWeather() {
        return weather;
    }

    public String getDistance() {
        return distance;
    }
}
