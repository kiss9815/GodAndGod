package com.juntcompany.godandgod.Main.Home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.Data.sendData;
import com.juntcompany.godandgod.R;

/**
 * Created by EOM on 2016-04-29.
 */
public class HomePostViewHolder extends RecyclerView.ViewHolder {

    ImageView homeUserPicture;
    TextView homeUserName;
    TextView homeTextTime;
    ImageView homeContentPic;
    TextView homeContent;
    TextView homeUserLikeNum;
    TextView homeUserCommentNum;

    public HomePostViewHolder(View itemView) {
        super(itemView);

        homeUserPicture = (ImageView)itemView.findViewById(R.id.homeUserPicture);
        homeUserName = (TextView)itemView.findViewById(R.id.homeUserName);
        homeTextTime = (TextView)itemView.findViewById(R.id.homeTextTime);
        homeContentPic = (ImageView)itemView.findViewById(R.id.homeContentPic);
        homeContent =(TextView)itemView.findViewById(R.id.homeContent);
        homeUserLikeNum = (TextView)itemView.findViewById(R.id.homeUserLikeNum);
        homeUserCommentNum = (TextView)itemView.findViewById(R.id.homeUserCommentNum);
    }

    public void setData(sendData send){
        homeUserPicture.setImageDrawable(send.postHomeUserPicture);
        homeUserName.setText(send.postHomeUserName);
        homeTextTime.setText(send.postHomeTextTime);
        homeContentPic.setImageDrawable(send.postHomeContentPic);
        homeContent.setText(send.postHomeContent);
        homeUserLikeNum.setText(send.postHomeUserLikeNum);
        homeUserCommentNum.setText(send.postHomeUserCommentNum);

    }

}
