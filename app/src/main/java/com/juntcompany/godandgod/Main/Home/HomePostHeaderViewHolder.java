package com.juntcompany.godandgod.Main.Home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.juntcompany.godandgod.R;

/**
 * Created by EOM on 2016-04-29.
 */
public class HomePostHeaderViewHolder extends RecyclerView.ViewHolder{
    TextView textView;

    public HomePostHeaderViewHolder(View itemView) {
        super(itemView);
        textView = (TextView)itemView.findViewById(R.id.text);
    }

    public void setDate(String title){
        textView.setText(title);
    }
}
