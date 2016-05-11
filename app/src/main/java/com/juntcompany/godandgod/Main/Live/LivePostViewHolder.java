package com.juntcompany.godandgod.Main.Live;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.R;

/**
 * Created by Jiseong on 2016-05-10.
 */

public class LivePostViewHolder extends RecyclerView.ViewHolder {


    ImageView livePicture;
    TextView liveName;
    TextView liveUser;
    TextView liveViewCount;

    public LivePostViewHolder(View itemView) {
        super(itemView);
        livePicture = (ImageView) itemView.findViewById(R.id.livePicture);
        liveName = (TextView) itemView.findViewById(R.id.liveName);
        liveUser = (TextView) itemView.findViewById(R.id.liveUser);
        liveViewCount = (TextView) itemView.findViewById(R.id.liveViewCount);
    }

    public void setData(Post post) {
        livePicture.setImageDrawable(post.postLivePicture);
        liveName.setText(post.postLiveName);
        liveUser.setText(post.postLiveUser);
        liveViewCount.setText(post.postLiveViewCount);

    }


}