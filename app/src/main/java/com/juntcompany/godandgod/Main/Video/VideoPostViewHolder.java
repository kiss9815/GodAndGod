package com.juntcompany.godandgod.Main.Video;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.R;

/**
 * Created by Jiseong on 2016-05-10.
 */
public class VideoPostViewHolder extends RecyclerView.ViewHolder {


    ImageView updateVideoPic;
    TextView updateVideoName;
    TextView updateVideoUser;
    TextView viewCount;
    TextView updateTime;

    public VideoPostViewHolder(View itemView) {
        super(itemView);
        updateVideoPic = (ImageView) itemView.findViewById(R.id.updateVideoPic);
        updateVideoName = (TextView) itemView.findViewById(R.id.updateVideoName);
        updateVideoUser = (TextView) itemView.findViewById(R.id.updateVideoUser);
        viewCount = (TextView) itemView.findViewById(R.id.viewCount);
        updateTime = (TextView) itemView.findViewById(R.id.updateTime);
    }

    public void setData(Post post) {
        updateVideoPic.setImageDrawable(post.postVideoPic);
        updateVideoName.setText(post.postVideoName);
        updateVideoUser.setText(post.postVideoUser);
        viewCount.setText(post.postVideoviewCount);
        updateTime.setText(post.postVideoUpdateTime);

    }


}