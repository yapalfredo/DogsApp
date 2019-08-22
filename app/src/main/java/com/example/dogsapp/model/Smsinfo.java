package com.example.dogsapp.model;

public class Smsinfo {
    public String to;
    public String text;
    public String imageUrl;

    public Smsinfo(String to, String text, String imageUrl) {
        this.to = to;
        this.text = text;
        this.imageUrl = imageUrl;
    }
}
