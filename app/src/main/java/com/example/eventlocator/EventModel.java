package com.example.eventlocator;

public class EventModel {

    private String eventName;
    private int eventPicture;


    public EventModel()
    {}
    public EventModel(String eventName, int eventPicture)
    {

        this.eventName = eventName;
        this.eventPicture = eventPicture;

    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getEventPicture() {
        return eventPicture;
    }

    public void setEventPicture(int eventPicture) {
        this.eventPicture = eventPicture;
    }

}
