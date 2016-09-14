package com.example.mike.itstepandroid.telegram.model.photo;

import java.util.List;

/**
 * Created by Mike on 16.08.2016.
 */
public class Result {
    private int total_count;
    private List<List<Photo>> photos;

    public int getTotal_count() {
        return total_count;
    }

    public List<List<Photo>> getPhotos() {
        return photos;
    }
}
