package com.juntcompany.godandgod.Main.Love;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.R;

/**
 * Created by Jiseong on 2016-05-10.
 */
public class LovePostViewHolder extends RecyclerView.ViewHolder {


    ImageView imageUserPicture;
    TextView textUserName;
    TextView textStatue;
    TextView textPostContent;
    TextView textTime;

    public LovePostViewHolder(View itemView) {
        super(itemView);
        imageUserPicture = (ImageView) itemView.findViewById(R.id.imageUserPicture);
        textUserName = (TextView) itemView.findViewById(R.id.userName);
        textStatue = (TextView) itemView.findViewById(R.id.updateStatue);
        textPostContent = (TextView) itemView.findViewById(R.id.updateContent);
        textTime = (TextView) itemView.findViewById(R.id.updateTime);
    }

    public void setData(Post post) {
        imageUserPicture.setImageDrawable(post.postLoveUserPicture);
        textUserName.setText(post.postLoveUserName);
        textStatue.setText(post.postLoveStatue);
        textPostContent.setText(post.postLoveContent);
        textTime.setText(post.postLoveUpdateTime);

    }

}