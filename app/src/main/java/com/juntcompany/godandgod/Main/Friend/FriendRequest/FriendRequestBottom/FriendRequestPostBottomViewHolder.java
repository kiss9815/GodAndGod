package com.juntcompany.godandgod.Main.Friend.FriendRequest.FriendRequestBottom;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.R;

/**
 * Created by Jiseong on 2016-05-12.
 */
public class FriendRequestPostBottomViewHolder extends RecyclerView.ViewHolder {


    ImageView friendPushFriendPicture;
    TextView friendPushFriendName;
    TextView friendPushFriendReligion;

    public FriendRequestPostBottomViewHolder(View itemView) {
        super(itemView);

        friendPushFriendPicture = (ImageView) itemView.findViewById(R.id.friendPushFriendPicture);
        friendPushFriendName = (TextView) itemView.findViewById(R.id.friendPushFriendName);
        friendPushFriendReligion = (TextView) itemView.findViewById(R.id.friendPushFriendReligion);
    }

    public void setData(Post post) {

        friendPushFriendPicture.setImageDrawable(post.postFriendPushFriendPicture);
        friendPushFriendName.setText(post.postFriendPushFriendName);
        friendPushFriendReligion.setText(post.postFriendPushFriendReligion);

    }

}