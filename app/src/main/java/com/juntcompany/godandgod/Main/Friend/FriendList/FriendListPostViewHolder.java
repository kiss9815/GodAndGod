package com.juntcompany.godandgod.Main.Friend.FriendList;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.R;

/**
 * Created by Jiseong on 2016-05-12.
 */
public class FriendListPostViewHolder extends RecyclerView.ViewHolder {


    ImageView friendListFriendPicture;
    TextView friendListFriendName;
    TextView friendListFriendArea;
    TextView friendListFriendReligion;

    public FriendListPostViewHolder(View itemView) {
        super(itemView);
        friendListFriendPicture = (ImageView) itemView.findViewById(R.id.friendListFriendPicture);
        friendListFriendName = (TextView) itemView.findViewById(R.id.friendListFriendName);
        friendListFriendArea = (TextView) itemView.findViewById(R.id.friendListFriendArea);
        friendListFriendReligion = (TextView) itemView.findViewById(R.id.friendListFriendReligion);
    }

    public void setData(Post post) {
        friendListFriendPicture.setImageDrawable(post.postFriendListFriendPicture);
        friendListFriendName.setText(post.postFriendListFriendName);
        friendListFriendArea.setText(post.postFriendListFriendArea);
        friendListFriendReligion.setText(post.postFriendListFriendReligion);

    }

}