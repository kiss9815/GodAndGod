package com.juntcompany.godandgod.Main.Search;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.juntcompany.godandgod.R;

/**
 * Created by Jiseong on 2016-05-12.
 */
public class SearchPostTopHeaderViewHolder extends RecyclerView.ViewHolder{
    TextView textView;

    public SearchPostTopHeaderViewHolder(View itemView) {
        super(itemView);
        textView = (TextView)itemView.findViewById(R.id.text);
    }

    public void setDate(String title){
        textView.setText(title);
    }
}