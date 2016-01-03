package com.example.linux.facebookfeeds;

/**
 * Created by Linux on 1/3/16.
 */
public class Event {

    String message;
    String created_time;
    String id;

    public String getMessage() {
        return message;
    }

    public String getCreated_time() {
        return created_time;
    }

    public String getId() {
        return id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return this.message;
    }


}
