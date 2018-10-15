package com.thedevs.mrkai.dyuksha18;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thedevs.mrkai.dyuksha18.Models.MessageModel;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Activity activity;
    private List<MessageModel> msgs;

    public ChatAdapter(List<MessageModel> msgs, Activity activity) {
        this.msgs = msgs;
        this.activity = activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.chatbox, parent, false);
        return new UserViewHolder(view);
    }
    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.setIsRecyclable(false);
        if (holder instanceof UserViewHolder) {
            final MessageModel msg = msgs.get(position);
            final UserViewHolder userViewHolder = (UserViewHolder) holder;
            if(msg.getMsgType().equals("MSG_TYPE_SENT")){
                userViewHolder.sendbox.setVisibility(View.VISIBLE);
                userViewHolder.send.setText(msg.getMsgContent());
                userViewHolder.receivebox.setVisibility(View.GONE);
            }
            else if(msg.getMsgType().equals("MSG_TYPE_RECEIVED")){
                userViewHolder.receivebox.setVisibility(View.VISIBLE);
                userViewHolder.receive.setText(msg.getMsgContent());
                userViewHolder.sendbox.setVisibility(View.GONE);
            }
        }
    }
    @Override
    public int getItemCount() {
        return msgs.size();
    }

    private class UserViewHolder extends RecyclerView.ViewHolder {
        TextView send;
        TextView receive;
        LinearLayout sendbox,receivebox;

        UserViewHolder(View view) {
            super(view);
            receivebox = view.findViewById(R.id.receivebox);
            sendbox = view.findViewById(R.id.sendbox);
            receive = view.findViewById(R.id.receiveText);
            send = view.findViewById(R.id.sendText);
        }
    }
}

