package com.example.mike.itstepandroid.telegram.asynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mike.itstepandroid.R;
import com.example.mike.itstepandroid.telegram.TelegramClient;
import com.example.mike.itstepandroid.telegram.adapter.MessageAdapter;
import com.example.mike.itstepandroid.telegram.model.RootGetUpdates;

import java.io.IOException;

/**
 * Created by Mike on 27.07.2016.
 */
public class AsyncTaskGetUpdates extends AsyncTask<Void, Void, RootGetUpdates> {

    private Activity activity;

    public AsyncTaskGetUpdates(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected RootGetUpdates doInBackground(Void... params) {
        TelegramClient telegramClient = new TelegramClient();

        try {
            return telegramClient.getUpdates();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(RootGetUpdates rootGetUpdates) {
        super.onPostExecute(rootGetUpdates);

        if(rootGetUpdates != null && rootGetUpdates.isOk()){
            if (rootGetUpdates.getList().size() == 0){
                Toast.makeText(activity, "No new messages", Toast.LENGTH_LONG).show();
            }
            ListView listView = (ListView) activity.findViewById(R.id.lvTelegram);
            ((MessageAdapter)listView.getAdapter()).getMessages().clear();
            ((MessageAdapter) listView.getAdapter()).getMessages().addAll(rootGetUpdates.getList());
            ((MessageAdapter) listView.getAdapter()).notifyDataSetChanged();
        } else {
            Toast.makeText(activity, "False Response", Toast.LENGTH_LONG).show();
        }
    }
}
