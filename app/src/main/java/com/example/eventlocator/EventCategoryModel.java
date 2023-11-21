package com.example.eventlocator;

public class EventCategoryModel {

    private int image;
    private String categoryName;

    public EventCategoryModel()
    {

    }

    public EventCategoryModel(int image, String categoryName) {
        this.image = image;
        this.categoryName = categoryName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
