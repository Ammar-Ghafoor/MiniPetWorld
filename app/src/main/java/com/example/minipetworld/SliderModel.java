package com.example.minipetworld;

public class SliderModel {
private int banner;
private String backgroundColor;

    public SliderModel(int banner, String backgroundColor) {
        this.banner = banner;
        this.backgroundColor = backgroundColor;
    }

    public int getBanner() {
        return banner;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBanner(int banner) {
        this.banner = banner;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
