package com.juntcompany.godandgod.Main.Live;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.juntcompany.godandgod.R;

/**
 * Created by Jiseong on 2016-05-10.
 */

public class LivePostHeaderViewHolder extends RecyclerView.ViewHolder{
    TextView textView;

    public LivePostHeaderViewHolder(View itemView) {
        super(itemView);
        textView = (TextView)itemView.findViewById(R.id.text);
    }

    public void setDate(String title){
        textView.setText(title);
    }
}
