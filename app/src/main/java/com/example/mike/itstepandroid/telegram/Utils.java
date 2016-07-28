package com.example.mike.itstepandroid.telegram;

import java.text.SimpleDateFormat;

/**
 * Created by Mike on 27.07.2016.
 */
public class Utils {
    public static String getDate(long date){
        SimpleDateFormat fullDateFormat = new SimpleDateFormat("HH.mm  dd.MM.yy");
        return fullDateFormat.format(date);
    }
}
