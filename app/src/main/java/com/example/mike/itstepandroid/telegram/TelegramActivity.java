package com.example.mike.itstepandroid.telegram;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mike.itstepandroid.R;

import java.io.IOException;

public class TelegramActivity extends AppCompatActivity implements View.OnClickListener {

    private String repsonse;
    private TextView tvTelegram;
    private AsyncTask<String, Void, String> asyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telegram);

        tvTelegram = (TextView) findViewById(R.id.tvTelegram);

        asyncTask = new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... params) {

                TelegramClient telegramClient = new TelegramClient();

                try {
                    repsonse = telegramClient.getUpdates();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return repsonse;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                tvTelegram.setText(s);
            }
        };
        
    }

    @Override
    public void onClick(View v) {
        asyncTask.execute();
    }
}
