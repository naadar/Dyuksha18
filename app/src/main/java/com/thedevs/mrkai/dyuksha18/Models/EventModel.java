package com.thedevs.mrkai.dyuksha18.Models;

public class EventModel {

    String title;
    String description;
    String date_and_time;
    String image_url;
    //    Add contact numbers
    String register_redirect_url;

    public EventModel(String title, String description, String date_and_time, String image_url, String register_redirect_url) {
        this.title = title;
        this.description = description;
        this.date_and_time = date_and_time;
        this.image_url = image_url;
        this.register_redirect_url = register_redirect_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_and_time() {
        return date_and_time;
    }

    public void setDate_and_time(String date_and_time) {
        this.date_and_time = date_and_time;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getRegister_redirect_url() {
        return register_redirect_url;
    }

    public void setRegister_redirect_url(String register_redirect_url) {
        this.register_redirect_url = register_redirect_url;
    }
}
