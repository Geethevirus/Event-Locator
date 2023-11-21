package com.example.eventlocator;

public class ItemPlace {

    private String eName;
    private int ePicture;


    public ItemPlace()
    {

    }

    public ItemPlace(String eName, int ePicture) {
        this.eName = eName;
        this.ePicture = ePicture;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public int getePicture() {
        return ePicture;
    }

    public void setePicture(int ePicture) {
        this.ePicture = ePicture;
    }
}
