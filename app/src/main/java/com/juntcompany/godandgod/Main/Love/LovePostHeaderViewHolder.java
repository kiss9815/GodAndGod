package com.juntcompany.godandgod.Main.Love;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.juntcompany.godandgod.R;


public class LovePostHeaderViewHolder extends RecyclerView.ViewHolder{
    TextView textView;

    public LovePostHeaderViewHolder(View itemView) {
        super(itemView);
        textView = (TextView)itemView.findViewById(R.id.text);
    }

    public void setDate(String title){
        textView.setText(title);
    }
}