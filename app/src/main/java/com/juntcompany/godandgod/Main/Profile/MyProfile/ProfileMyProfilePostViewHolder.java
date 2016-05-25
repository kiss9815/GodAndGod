package com.juntcompany.godandgod.Main.Profile.MyProfile;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.Data.sendData;
import com.juntcompany.godandgod.R;

public class ProfileMyProfilePostViewHolder extends RecyclerView.ViewHolder {

    ImageView myProfileUserPicture;
    TextView myProfileUserName;
    TextView myProfileTextTime;
    ImageView myProfileContentPic;
    TextView myProfileContent;
    TextView myProfileUserLikeNum;
    TextView myProfileUserCommentNum;

    public ProfileMyProfilePostViewHolder(View itemView) {
        super(itemView);

        myProfileUserPicture = (ImageView)itemView.findViewById(R.id.myProfileUserPicture);
        myProfileUserName = (TextView)itemView.findViewById(R.id.myProfileUserName);
        myProfileTextTime = (TextView)itemView.findViewById(R.id.myProfileTextTime);
        myProfileContentPic = (ImageView)itemView.findViewById(R.id.myProfileContentPic);
        myProfileContent =(TextView)itemView.findViewById(R.id.myProfileContent);
        myProfileUserLikeNum = (TextView)itemView.findViewById(R.id.myProfileUserLikeNum);
        myProfileUserCommentNum = (TextView)itemView.findViewById(R.id.myProfileUserCommentNum);
    }

    public void setData(sendData sendData){
        myProfileUserPicture.setImageDrawable(sendData.postMyProfileUserPicture);
        myProfileUserName.setText(sendData.postMyProfileUserName);
        myProfileTextTime.setText(sendData.postMyProfileTextTime);
        myProfileContentPic.setImageDrawable(sendData.postMyProfileContentPic);
        myProfileContent.setText(sendData.postMyProfileContent);
        myProfileUserLikeNum.setText(sendData.postMyProfileUserLikeNum);
        myProfileUserCommentNum.setText(sendData.postMyProfileUserCommentNum);

    }

}
