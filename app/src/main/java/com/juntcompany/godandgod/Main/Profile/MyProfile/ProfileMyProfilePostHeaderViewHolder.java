package com.juntcompany.godandgod.Main.Profile.MyProfile;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.R;

/**
 * Created by Jiseong on 2016-05-10.
 */
public class ProfileMyProfilePostHeaderViewHolder extends RecyclerView.ViewHolder{
    ImageView myProfileUserPicture;
    TextView myProfileUserName;
    TextView myProfileComment;
    TextView MyProfileReligion;
    TextView MyProfileFavoriteNum;
    TextView MyProfileFriendNum;

    public ProfileMyProfilePostHeaderViewHolder(View itemView) {
        super(itemView);
        myProfileUserPicture = (ImageView)itemView.findViewById(R.id.myProfileUserPicture);
        myProfileUserName = (TextView)itemView.findViewById(R.id.myProfileUserName);
        myProfileComment = (TextView)itemView.findViewById(R.id.myProfileComment);
        MyProfileReligion =(TextView)itemView.findViewById(R.id.myProfileReligion);
        MyProfileFavoriteNum = (TextView)itemView.findViewById(R.id.myProfileFavoriteNum);
        MyProfileFriendNum = (TextView)itemView.findViewById(R.id.myProfileFriendNum);
        myProfileUserPicture.setBackgroundResource(R.drawable.gnd);
        myProfileUserName.setText("GnG");
        myProfileComment.setText("열심히 프로필 작업중");
        MyProfileReligion.setText("기독교");
        MyProfileFavoriteNum.setText("1000000");
        MyProfileFriendNum.setText("10000");
    }

}
