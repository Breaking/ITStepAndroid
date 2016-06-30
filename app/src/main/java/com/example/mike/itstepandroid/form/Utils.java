package com.example.mike.itstepandroid.form;

import java.text.SimpleDateFormat;

/**
 * Created by Mike on 19.06.2016.
 */
public class Utils {
    public static String getDate(long date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
        return dateFormat.format(date);
    }


}
