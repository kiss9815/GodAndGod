package com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupCreate.ChatGroupCreateBottom;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.R;

/**
 * Created by Jiseong on 2016-05-15.
 */
public class ChatGroupCreateBottomPostViewHolder extends RecyclerView.ViewHolder {


    ImageView inputFriendPic;
    TextView inputFriendName;

    public ChatGroupCreateBottomPostViewHolder(View itemView) {
        super(itemView);
        inputFriendPic = (ImageView) itemView.findViewById(R.id.inputFriendPic);
        inputFriendName = (TextView) itemView.findViewById(R.id.inputFriendName);
    }

    public void setData(Post post) {
        inputFriendPic.setImageDrawable(post.postInputFriendPic);
        inputFriendName.setText(post.postInputFriendName);

    }

}