package com.example.mike.itstepandroid.telegram.asynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mike.itstepandroid.R;
import com.example.mike.itstepandroid.telegram.TelegramClient;
import com.example.mike.itstepandroid.telegram.adapter.MessageAdapter;
import com.example.mike.itstepandroid.telegram.model.From;
import com.example.mike.itstepandroid.telegram.model.MsgInfo;
import com.example.mike.itstepandroid.telegram.model.Result;
import com.example.mike.itstepandroid.telegram.model.RootGetUpdates;
import com.example.mike.itstepandroid.telegram.model.photo.Photo;
import com.example.mike.itstepandroid.telegram.model.photo.PhotoURL;
import com.example.mike.itstepandroid.telegram.model.photo.RootGetPhotos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mike on 27.07.2016.
 */
public class AsyncTaskGetUpdates extends AsyncTask<Void, Void, List<MsgInfo>> {

    private Activity activity;

    public final static String PHOTO_PATH = "https://api.telegram.org/file/bot227256644:AAHLJkW13C03wXxUgq_JjMAcYq-X6thn9hU/";

    public AsyncTaskGetUpdates(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected List<MsgInfo> doInBackground(Void... params) {



        TelegramClient telegramClient = new TelegramClient();
        List<MsgInfo> msgInfoList = new ArrayList<>();

        try {
            //return telegramClient.getUpdates();
            RootGetUpdates updates = telegramClient.getUpdates();

            for (Result resultItem: updates.getList()) {
                MsgInfo msgInfo = new MsgInfo();
                msgInfo.setFrom_id(resultItem.getMessage().getFrom().getId());
                msgInfo.setChat_id(resultItem.getMessage().getChat().getId());
                msgInfo.setDate(resultItem.getMessage().getDate());
                msgInfo.setText(resultItem.getMessage().getText());
                msgInfo.setFirst_name(resultItem.getMessage().getFrom().getFirst_name());
                msgInfo.setLast_name(resultItem.getMessage().getFrom().getLast_name());
                msgInfoList.add(msgInfo);
            }

//            for (int i = 0; i < updates.getList().size(); i++) {
//                MsgInfo msgInfo = new MsgInfo();
//                msgInfo.setFrom_id(updates.getList().get(i).getMessage().getFrom().getId());
//                msgInfo.setChat_id(updates.getList().get(i).getMessage().getChat().getId());
//                msgInfo.setText(updates.getList().get(i).getMessage().getText());
//                msgInfo.setFirst_name(updates.getList().get(i).getMessage().getFrom().getFirst_name());
//                msgInfo.setLast_name(updates.getList().get(i).getMessage().getFrom().getLast_name());
//                msgInfoList.add(msgInfo);
//            }

            Map<Long, String> userIdToPhoto = new HashMap<>();

            for (MsgInfo msgInfoItem: msgInfoList){
                if (userIdToPhoto.containsKey(msgInfoItem.getFrom_id())){
                    msgInfoItem.setFile_path(userIdToPhoto.get(msgInfoItem.getFrom_id()));
                } else {
                    RootGetPhotos rootGetPhotos = telegramClient.getPhotos(msgInfoItem.getFrom_id());
                    if (rootGetPhotos.getResult().getTotal_count() > 0) {
                        List<Photo> photoList = rootGetPhotos.getResult().getPhotos().get(rootGetPhotos.getResult().getPhotos().size() - 1);
                        for (Photo photo: photoList) {
                            if (photo.getWidth() == 320){
                                String file_id = photo.getFile_id();
                                PhotoURL photoURL = telegramClient.getPhotoURL(file_id);
                                msgInfoItem.setFile_path(PHOTO_PATH + photoURL.getResult().getFile_path());
                                userIdToPhoto.put(msgInfoItem.getFrom_id(), msgInfoItem.getFile_path());
                                //put into map
                                break;
                            }
                        }
                    }
                }

            }

            return msgInfoList;

//            long user_id = -1;
//            for (int i = 0; i < msgInfoList.size() ; i++) {
//                if (msgInfoList.get(i).getFrom_id() != user_id ){
//                    user_id = msgInfoList.get(i).getFrom_id();
//                    RootGetPhotos rootGetPhotos = telegramClient.getPhotos(user_id);
//                }
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(List<MsgInfo> msgInfoList) {
        super.onPostExecute(msgInfoList);

        if(msgInfoList.size() != 0){
            ListView listView = (ListView) activity.findViewById(R.id.lvTelegram);
            ((MessageAdapter) listView.getAdapter()).getMsgInfoList().clear();
            ((MessageAdapter) listView.getAdapter()).getMsgInfoList().addAll(msgInfoList);
            ((MessageAdapter) listView.getAdapter()).notifyDataSetChanged();
        } else {
            Toast.makeText(activity, "No new messages", Toast.LENGTH_LONG).show();
        }
    }
}
