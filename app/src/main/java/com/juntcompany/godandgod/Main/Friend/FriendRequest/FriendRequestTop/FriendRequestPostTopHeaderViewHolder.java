package com.juntcompany.godandgod.Main.Friend.FriendRequest.FriendRequestTop;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.R;

/**
 * Created by Jiseong on 2016-05-12.
 */

public class FriendRequestPostTopHeaderViewHolder extends RecyclerView.ViewHolder{
    TextView friendRequestTopHeader;

    public FriendRequestPostTopHeaderViewHolder(View itemView) {
        super(itemView);
        friendRequestTopHeader = (TextView)itemView.findViewById(R.id.friendRequestTopHeader);
    }

    public void setData(Post post){
        friendRequestTopHeader.setText(post.postFriendRequestTopHeader);
    }
}