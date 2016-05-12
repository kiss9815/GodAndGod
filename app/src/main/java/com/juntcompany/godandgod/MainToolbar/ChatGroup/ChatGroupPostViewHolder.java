package com.juntcompany.godandgod.MainToolbar.ChatGroup;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.R;

/**
 * Created by Jiseong on 2016-05-11.
 */
public class ChatGroupPostViewHolder extends RecyclerView.ViewHolder {


    ImageView chatLeftGroupPicture;
    TextView chatLeftGroupName;
    TextView chatLeftGroupUser;
    ImageView chatRightGroupPicture;
    TextView chatRightGroupName;
    TextView chatRightGroupUser;

    public ChatGroupPostViewHolder(View itemView) {
        super(itemView);
        chatLeftGroupPicture = (ImageView) itemView.findViewById(R.id.chatLeftGroupPicture);
        chatLeftGroupName = (TextView) itemView.findViewById(R.id.chatLeftGroupName);
        chatLeftGroupUser = (TextView) itemView.findViewById(R.id.chatLeftGroupUser);
        chatRightGroupPicture = (ImageView) itemView.findViewById(R.id.chatRightGroupPicture);
        chatRightGroupName = (TextView) itemView.findViewById(R.id.chatRightGroupName);
        chatRightGroupUser = (TextView) itemView.findViewById(R.id.chatRightGroupUser);
    }

    public void setData(Post post) {
        chatLeftGroupPicture.setImageDrawable(post.postChatLeftGroupPicture);
        chatLeftGroupName.setText(post.postChatLeftGroupName);
        chatLeftGroupUser.setText(post.postChatLeftGroupUser);
        chatRightGroupPicture.setImageDrawable(post.postChatRightGroupPicture);
        chatRightGroupName.setText(post.postChatRightGroupName);
        chatRightGroupUser.setText(post.postChatRightGroupUser);

    }

}