package com.juntcompany.godandgod.Main.Profile.MyProfile;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.R;

public class ProfileMyProfilePostViewHolder extends RecyclerView.ViewHolder {

    ImageView myProfileUserPicture;
    TextView myProfileUserName;
    TextView myProfileTextTime;
    TextView myProfileContent;
    TextView myProfileUserLikeNum;
    TextView myProfileUserCommentNum;

    public ProfileMyProfilePostViewHolder(View itemView) {
        super(itemView);

        myProfileUserPicture = (ImageView)itemView.findViewById(R.id.myProfileUserPicture);
        myProfileUserName = (TextView)itemView.findViewById(R.id.myProfileUserName);
        myProfileTextTime = (TextView)itemView.findViewById(R.id.myProfileTextTime);
        myProfileContent =(TextView)itemView.findViewById(R.id.myProfileContent);
        myProfileUserLikeNum = (TextView)itemView.findViewById(R.id.myProfileUserLikeNum);
        myProfileUserCommentNum = (TextView)itemView.findViewById(R.id.myProfileUserCommentNum);
    }

    public void setData(Post post){
        myProfileUserPicture.setImageDrawable(post.postMyProfileUserPicture);
        myProfileUserName.setText(post.postMyProfileUserName);
        myProfileTextTime.setText(post.postMyProfileTextTime);
        myProfileContent.setText(post.postMyProfileContent);
        myProfileUserLikeNum.setText(post.postMyProfileUserLikeNum);
        myProfileUserCommentNum.setText(post.postMyProfileUserCommentNum);

    }

}
