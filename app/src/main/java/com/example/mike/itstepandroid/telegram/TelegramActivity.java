package com.example.mike.itstepandroid.telegram;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mike.itstepandroid.R;
import com.example.mike.itstepandroid.telegram.model.Root;

import java.io.IOException;

public class TelegramActivity extends AppCompatActivity implements View.OnClickListener {

    private Root root;
    private TextView tvTelegram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telegram);

        tvTelegram = (TextView) findViewById(R.id.tvTelegram);

    }

    @Override
    public void onClick(View v) {
        //asyncTask.execute();
        new JSonTask().execute();
    }

    public class JSonTask extends AsyncTask<Void, Void, Root>{

        @Override
        protected Root doInBackground(Void... params) {
            TelegramClient telegramClient = new TelegramClient();

            try {
                root = new Root();
                root = telegramClient.getUpdates();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return root;
        }

        @Override
        protected void onPostExecute(Root root) {
            super.onPostExecute(root);
            if (root.getList().size() == 0){
                tvTelegram.setText("No new messages!");
            } else{
                tvTelegram.setText(root.getList().get(1).getMessage().getText());
            }

        }
    }
}

