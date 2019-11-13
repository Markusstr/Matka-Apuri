package com.example.matka_apuri;

public class RecyclerViewDataClass {
    private String imageName;
    private boolean close;
    private String name;
    private String info;

    RecyclerViewDataClass(String imageName, boolean close, String name, String info) {
        this.imageName = imageName;
        this.close = close;
        this.name = name;
        this.info = info;
    }

    public String getImageName() {
        return imageName;
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
