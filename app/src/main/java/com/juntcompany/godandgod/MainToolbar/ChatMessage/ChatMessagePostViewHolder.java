package com.juntcompany.godandgod.MainToolbar.ChatMessage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.R;

/**
 * Created by Jiseong on 2016-05-10.
 */
public class ChatMessagePostViewHolder extends RecyclerView.ViewHolder {


    ImageView ChatMessageRoomPicture;
    TextView ChatMessageRoomName;
    TextView ChatMessageRoomContent;
    TextView ChatMessageUpdateTime;

    public ChatMessagePostViewHolder(View itemView) {
        super(itemView);
        ChatMessageRoomPicture = (ImageView) itemView.findViewById(R.id.ChatMessageRoomPicture);
        ChatMessageRoomName = (TextView) itemView.findViewById(R.id.ChatMessageRoomName);
        ChatMessageRoomContent = (TextView) itemView.findViewById(R.id.ChatMessageRoomContent);
        ChatMessageUpdateTime = (TextView) itemView.findViewById(R.id.ChatMessageUpdateTime);
    }

    public void setData(Post post) {
        ChatMessageRoomPicture.setImageDrawable(post.postChatMessageRoomPicture);
        ChatMessageRoomName.setText(post.postChatMessageRoomName);
        ChatMessageRoomContent.setText(post.postChatMessageRoomContent);
        ChatMessageUpdateTime.setText(post.postChatMessageUpdateTime);

    }

}