package com.example.mike.itstepandroid.telegram;

import com.example.mike.itstepandroid.telegram.model.Root;
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

    private String get(String url) throws IOException{
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();

    }

    protected Root getUpdates() throws IOException {
        Gson gson = new Gson();
        Root root = gson.fromJson(get(UPDATE_URL),
                Root.class);
        return root;
    }
}
