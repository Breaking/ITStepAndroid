package com.example.mike.itstepandroid.telegram.model;

import java.util.List;

/**
 * Created by Mike on 30.06.2016.
 */
public class Root {
    private boolean ok;
    private List<Result> result;

    public boolean isOk() {
        return ok;
    }

    public List<Result> getList() {
        return result;
    }
}
