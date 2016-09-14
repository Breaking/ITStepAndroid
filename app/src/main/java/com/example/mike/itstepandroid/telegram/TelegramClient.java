package com.example.mike.itstepandroid.telegram;

import com.example.mike.itstepandroid.telegram.model.RootGetUpdates;
import com.example.mike.itstepandroid.telegram.model.photo.PhotoURL;
import com.example.mike.itstepandroid.telegram.model.photo.RootGetPhotos;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Mike on 28.06.2016.
 */
public class TelegramClient  {
    public final static String API_KEY = "227256644:AAHLJkW13C03wXxUgq_JjMAcYq-X6thn9hU";
    public final static String UPDATE_URL = "https://api.telegram.org/bot" + API_KEY +"/getUpdates";
    public final static String GET_USER_PHOTOS = "https://api.telegram.org/bot" + API_KEY + "/getUserProfilePhotos?user_id=";
    public final static String GET_PHOTO_URL = "https://api.telegram.org/bot" + API_KEY + "/getFile?file_id=";

    private String get(String url) throws IOException{
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();

    }

    public RootGetUpdates getUpdates() throws IOException {
        Gson gson = new Gson();
        RootGetUpdates rootGetUpdates = gson.fromJson(get(UPDATE_URL),
                RootGetUpdates.class);
        return rootGetUpdates;
    }

    public RootGetPhotos getPhotos(long user_id) throws IOException {
        Gson gson = new Gson();
        RootGetPhotos rootGetPhotos = gson.fromJson(get(GET_USER_PHOTOS + user_id),
                RootGetPhotos.class);
        return rootGetPhotos;
    }

    public PhotoURL getPhotoURL(String file_id) throws IOException {
        Gson gson = new Gson();
        PhotoURL photoURL = gson.fromJson(get(GET_PHOTO_URL + file_id),
                PhotoURL.class);
        return photoURL;
    }

}
