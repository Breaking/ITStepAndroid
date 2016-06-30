package com.example.mike.itstepandroid.telegram;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Mike on 28.06.2016.
 */
public class TelegramClient  {

    private String get(String url) throws IOException{
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();

    }

    protected String getUpdates() throws IOException {
        return get("https://api.telegram.org/bot227256644:AAHLJkW13C03wXxUgq_JjMAcYq-X6thn9hU/getUpdates");
    }
}
