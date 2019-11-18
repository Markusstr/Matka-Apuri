package com.example.matka_apuri;

import android.graphics.Bitmap;

public class SearchDataClass {
    private Bitmap image;
    private String name;
    private String price;
    private String distance;
    private String review;

    SearchDataClass (Bitmap image, String name, String price, String distance, String review) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.distance = distance;
        this.review = review;

    }

    public Bitmap getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }


    public String getDistance() {
        return distance;
    }

    public String getReview() {
        return review;
    }
}
