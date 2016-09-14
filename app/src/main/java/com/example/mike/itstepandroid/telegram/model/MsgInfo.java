package com.example.mike.itstepandroid.telegram.model;

import java.util.Map;

/**
 * Created by Mike on 16.08.2016.
 */
public class MsgInfo {
    private long from_id;
    private long chat_id;
    private long date;
    private String text;
    private String first_name;
    private String last_name;
    private String file_path;
    //private Map<Long, String> PHOTO_MAP;


    public long getFrom_id() {
        return from_id;
    }

    public void setFrom_id(long from_id) {
        this.from_id = from_id;
    }

    public long getChat_id() {
        return chat_id;
    }

    public void setChat_id(long chat_id) {
        this.chat_id = chat_id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    //    public Map<Long, String> getPHOTO_MAP() {
//        return PHOTO_MAP;
//    }
//
//    public void setPHOTO_MAP(Map<Long, String> PHOTO_MAP) {
//        this.PHOTO_MAP = PHOTO_MAP;
//    }
}
