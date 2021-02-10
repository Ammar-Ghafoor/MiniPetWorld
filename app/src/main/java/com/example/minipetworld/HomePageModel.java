package com.example.minipetworld;

import java.util.List;

public class HomePageModel {


    public static final int BANNER_SLIDER = 0;
    public static final int STRIP_AD_BANNER =1;
    public static final int HORIZONTAL_PRODUCT_VIEW =2;
    public static final int GRID_PRODUCT_VIEW =3;


    private  int type;

    //////////////////////////banner slider
    private List<SliderModel> sliderModelList;
    public HomePageModel(int type, List<SliderModel> sliderModelList) {
        this.type = type;
        this.sliderModelList = sliderModelList;
    }
    public int getType() {
        return type;
    }
    public List<SliderModel> getSliderModelList() {
        return sliderModelList;
    }
    public void setType(int type)  {
        this.type = type;
    }
    public void setSliderModelList(List<SliderModel> sliderModelList) {
        this.sliderModelList = sliderModelList;
    }
    //////////////////////////banner slider



    ///////////////strip ad
    private int resource;
    private String backgroudColor;

    public HomePageModel(int type, int resource, String backgroudColor) {
        this.type = type;
        this.resource = resource;
        this.backgroudColor = backgroudColor;
    }
    public int getResource() {
        return resource;
    }
    public String getBackgroudColor() {
        return backgroudColor;
    }
    public void setResource(int resource) {
        this.resource = resource;
    }
    public void setBackgroudColor(String backgroudColor) {
        this.backgroudColor = backgroudColor;
    }
    ///////////////strip ad


    ////////////// Horizontal product layout and grid product layout
    private String title;
    private List<HorizontalProductScrollModel> horizontalProductScrollModelList;
    public HomePageModel(int type, String title, List<HorizontalProductScrollModel> horizontalProductScrollModelList) {
        this.type = type;
        this.title = title;
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }
    public String getTitle() {
        return title;
    }
    public List<HorizontalProductScrollModel> getHorizontalProductScrollModelList() {
        return horizontalProductScrollModelList;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setHorizontalProductScrollModelList(List<HorizontalProductScrollModel> horizontalProductScrollModelList) {
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }

    ////////////// Horizontal product layout and grid product layout






}
