package com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupCreate.ChatGroupCreateMiddle;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.R;

/**
 * Created by Jiseong on 2016-05-15.
 */
public class ChatGroupCreateMiddlePostViewHolder extends RecyclerView.ViewHolder {


    ImageView createGroupInputUserPic;
    TextView createGroupInputUserName;

    public ChatGroupCreateMiddlePostViewHolder(View itemView) {
        super(itemView);
        createGroupInputUserPic = (ImageView) itemView.findViewById(R.id.createGroupInputUserPic);
        createGroupInputUserName = (TextView) itemView.findViewById(R.id.createGroupInputUserName);
    }

    public void setData(Post post) {
        createGroupInputUserPic.setImageDrawable(post.postCreateGroupInputUserPic);
        createGroupInputUserName.setText(post.postCreateGroupInputUserName);

    }

}