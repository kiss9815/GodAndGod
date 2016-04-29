package com.juntcompany.godandgod.Main.Home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.R;

/**
 * Created by EOM on 2016-04-29.
 */
public class HomePostViewHolder extends RecyclerView.ViewHolder {


    TextView textUserName;
    TextView textPostContent;
    TextView textTime;
    ImageView imageUserPicture;

    public HomePostViewHolder(View itemView) {
        super(itemView);

        textUserName = (TextView)itemView.findViewById(R.id.textUserName);
        textPostContent = (TextView)itemView.findViewById(R.id.textPostContent);
        imageUserPicture = (ImageView)itemView.findViewById(R.id.imageUserPicture);
        textTime =(TextView)itemView.findViewById(R.id.textTime);
    }

    public void setData(Post post){
        textUserName.setText(post.postUserName);
        textPostContent.setText(post.postContent);
        textTime.setText(post.postUpdateTime);
        imageUserPicture.setImageDrawable(post.postUserPicture);

    }

}
