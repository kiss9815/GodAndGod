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

    ImageView homeUserPicture;
    TextView homeUserName;
    TextView homeTextTime;
    TextView homeContent;
    TextView homeUserLikeNum;
    TextView homeUserCommentNum;

    public HomePostViewHolder(View itemView) {
        super(itemView);

        homeUserPicture = (ImageView)itemView.findViewById(R.id.homeUserPicture);
        homeUserName = (TextView)itemView.findViewById(R.id.homeUserName);
        homeTextTime = (TextView)itemView.findViewById(R.id.homeTextTime);
        homeContent =(TextView)itemView.findViewById(R.id.homeContent);
        homeUserLikeNum = (TextView)itemView.findViewById(R.id.homeUserLikeNum);
        homeUserCommentNum = (TextView)itemView.findViewById(R.id.homeUserCommentNum);
    }

    public void setData(Post post){
        homeUserPicture.setImageDrawable(post.postHomeUserPicture);
        homeUserName.setText(post.postHomeUserName);
        homeTextTime.setText(post.postHomeTextTime);
        homeContent.setText(post.postHomeContent);
        homeUserLikeNum.setText(post.postHomeUserLikeNum);
        homeUserCommentNum.setText(post.postHomeUserCommentNum);

    }

}
