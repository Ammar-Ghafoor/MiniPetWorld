package com.example.minipetworld;

public class CategoryModel {

    String CategoryIconLink;
    String CategoryName;

    public CategoryModel(String categoryIconLink, String categoryName) {
        CategoryIconLink = categoryIconLink;
        CategoryName = categoryName;
    }

    public String getCategoryIconLink() {
        return CategoryIconLink;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryIconLink(String categoryIconLink) {
        CategoryIconLink = categoryIconLink;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}
