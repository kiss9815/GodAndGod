package com.juntcompany.godandgod.MainToolbar.ChatMessage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.juntcompany.godandgod.R;

/**
 * Created by Jiseong on 2016-05-10.
 */
public class ChatMessagePostHeaderViewHolder extends RecyclerView.ViewHolder{
    TextView textView;

    public ChatMessagePostHeaderViewHolder(View itemView) {
        super(itemView);
        textView = (TextView)itemView.findViewById(R.id.text);
    }

    public void setDate(String title){
        textView.setText(title);
    }
}