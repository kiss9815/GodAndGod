package com.juntcompany.godandgod.Main.Friend.FriendRequest.FriendRequestTop;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.R;

/**
 * Created by Jiseong on 2016-05-12.
 */
public class FriendRequestPostTopViewHolder extends RecyclerView.ViewHolder {


    ImageView friendRequestFriendPicture;
    TextView friendRequestFriendName;
    TextView friendRequestFriendReligion;

    public FriendRequestPostTopViewHolder(View itemView) {
        super(itemView);
        friendRequestFriendPicture = (ImageView) itemView.findViewById(R.id.friendRequestFriendPicture);
        friendRequestFriendName = (TextView) itemView.findViewById(R.id.friendRequestFriendName);
        friendRequestFriendReligion = (TextView) itemView.findViewById(R.id.friendRequestFriendReligion);
    }

    public void setData(Post post) {
        friendRequestFriendPicture.setImageDrawable(post.postFriendRequestFriendPicture);
        friendRequestFriendName.setText(post.postFriendRequestFriendName);
        friendRequestFriendReligion.setText(post.postFriendRequestFriendReligion);

    }

}