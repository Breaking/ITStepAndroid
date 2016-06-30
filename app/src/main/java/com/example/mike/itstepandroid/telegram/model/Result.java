package com.example.mike.itstepandroid.telegram.model;

/**
 * Created by Mike on 30.06.2016.
 */
public class Result {
    long update_id;
    Message message;

    public long getUpdate_id() {
        return update_id;
    }

    public Message getMessage() {
        return message;
    }
}
