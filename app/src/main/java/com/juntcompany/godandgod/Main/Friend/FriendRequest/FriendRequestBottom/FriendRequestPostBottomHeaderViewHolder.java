package com.juntcompany.godandgod.Main.Friend.FriendRequest.FriendRequestBottom;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.R;

/**
 * Created by Jiseong on 2016-05-12.
 */
public class FriendRequestPostBottomHeaderViewHolder extends RecyclerView.ViewHolder{
    TextView friendRequestBottomHeader;

    public FriendRequestPostBottomHeaderViewHolder(View itemView) {
        super(itemView);
        friendRequestBottomHeader = (TextView)itemView.findViewById(R.id.friendRequestBottomHeader);
    }

    public void setData(Post post){
        friendRequestBottomHeader.setText(post.postFriendRequestBottomHeader);
    }
}



