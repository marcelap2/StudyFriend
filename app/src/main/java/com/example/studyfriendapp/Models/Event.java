package com.example.studyfriendapp.Models;

public class Event {

    private String name, text;
    private int image;

    public Event(String name, String text, int image) {
        this.name = name;
        this.text = text;
        this.image = image;
    }

    public Event(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
