package com.example.mike.itstepandroid.telegram;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mike.itstepandroid.R;
import com.example.mike.itstepandroid.telegram.adapter.MessageAdapter;
import com.example.mike.itstepandroid.telegram.asynctask.AsyncTaskGetUpdates;
import com.example.mike.itstepandroid.telegram.model.Result;
import com.example.mike.itstepandroid.telegram.model.RootGetUpdates;

import java.io.IOException;
import java.util.ArrayList;

public class TelegramActivity extends AppCompatActivity implements View.OnClickListener {

    //private RootGetUpdates root;
    private TextView tvTelegram;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telegram);

        listView = (ListView) findViewById(R.id.lvTelegram);
        tvTelegram = (TextView) findViewById(R.id.tvTelegram);

        listView.setAdapter(new MessageAdapter(this, new ArrayList<Result>()));

    }

    @Override
    public void onClick(View v) {
        //asyncTask.execute();
        new JSonTask().execute();
    }

    @Override
    protected void onResume() {
        super.onResume();

        new AsyncTaskGetUpdates(this).execute();
    }

    public class JSonTask extends AsyncTask<Void, Void, RootGetUpdates>{

        @Override
        protected RootGetUpdates doInBackground(Void... params) {
            TelegramClient telegramClient = new TelegramClient();

            try {
//                root = new RootGetUpdates();
//                root = telegramClient.getUpdates();
                return telegramClient.getUpdates();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(RootGetUpdates rootGetUpdates) {
            super.onPostExecute(rootGetUpdates);
            if (rootGetUpdates.getList().size() == 0){
                tvTelegram.setText("No new messages!");
            } else{
                tvTelegram.setText(rootGetUpdates.getList().get(0).getMessage().getText());
            }

        }
    }
}

