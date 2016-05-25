package com.juntcompany.godandgod.Main.FriendInfo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.receiveData;
import com.juntcompany.godandgod.Data.sendData;
import com.juntcompany.godandgod.R;

/**
 * Created by Jiseong on 2016-05-25.
 */
public class FriendInfoViewHolder extends RecyclerView.ViewHolder {

    ImageView myFriendUserPicture;
    TextView myFriendUserName;
    TextView myFriendTextTime;
    ImageView myFriendContentPic;
    TextView myFriendContent;
    TextView myFriendUserLikeNum;
    TextView myFriendUserCommentNum;

    public FriendInfoViewHolder(View itemView) {
        super(itemView);

        myFriendUserPicture = (ImageView)itemView.findViewById(R.id.myFriendUserPicture);
        myFriendUserName = (TextView)itemView.findViewById(R.id.myFriendUserName);
        myFriendTextTime = (TextView)itemView.findViewById(R.id.myFriendTextTime);
        myFriendContentPic = (ImageView)itemView.findViewById(R.id.myFriendContentPic);
        myFriendContent =(TextView)itemView.findViewById(R.id.myFriendContent);
        myFriendUserLikeNum = (TextView)itemView.findViewById(R.id.myFriendUserLikeNum);
        myFriendUserCommentNum = (TextView)itemView.findViewById(R.id.myFriendUserCommentNum);
    }

    public void setData(receiveData receiveData){
        myFriendUserPicture.setImageDrawable(receiveData.postMyFriendUserPicture);
        myFriendUserName.setText(receiveData.postMyFriendUserName);
        myFriendTextTime.setText(receiveData.postMyFriendTextTime);
        myFriendContentPic.setImageDrawable(receiveData.postMyFriendContentPic);
        myFriendContent.setText(receiveData.postMyFriendContent);
        myFriendUserLikeNum.setText(receiveData.postMyFriendUserLikeNum);
        myFriendUserCommentNum.setText(receiveData.postMyFriendUserCommentNum);

    }

}
