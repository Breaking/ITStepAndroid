package com.example.mike.itstepandroid.telegram.model;

/**
 * Created by Mike on 30.06.2016.
 */
public class Message {
    private long message_id;
    private From from;
    private Chat chat;
    private long date;
    private String text;

    public long getMessage_id() {
        return message_id;
    }

    public From getFrom() {
        return from;
    }

    public Chat getChat() {
        return chat;
    }

    public long getDate() {
        return date;
    }

    public String getText() {
        return text;
    }
}
