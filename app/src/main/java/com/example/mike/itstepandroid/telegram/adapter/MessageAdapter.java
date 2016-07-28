package com.example.mike.itstepandroid.telegram.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mike.itstepandroid.R;
import com.example.mike.itstepandroid.telegram.Utils;
import com.example.mike.itstepandroid.telegram.model.Result;

import java.util.List;

/**
 * Created by Mike on 27.07.2016.
 */
public class MessageAdapter extends BaseAdapter {

    private Context context;
    private List<Result> messages;

    public MessageAdapter(Context context, List<Result> messages) {
        this.context = context;
        this.messages = messages;
    }

    public List<Result> getMessages() {
        return messages;
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int position) {
        return messages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Result message = messages.get(position);
        View resultView;

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        resultView = layoutInflater.inflate(R.layout.telegram_message_row, parent, false);
        ((TextView) resultView.findViewById(R.id.tvMessageText)).setText(message.getMessage().getText());
        ((TextView) resultView.findViewById(R.id.tvMessageSender)).setText(message.getMessage().getFrom().getFirst_name()
                + " " + message.getMessage().getFrom().getLast_name());
        ((TextView) resultView.findViewById(R.id.tvMessageDate)).setText(Utils.getDate(message.getMessage().getDate()));


        return resultView;
    }
}
