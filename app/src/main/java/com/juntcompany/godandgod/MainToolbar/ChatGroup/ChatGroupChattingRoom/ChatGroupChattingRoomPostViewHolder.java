package com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupChattingRoom;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.R;

/**
 * Created by Jiseong on 2016-05-16.
 */
public class ChatGroupChattingRoomPostViewHolder extends RecyclerView.ViewHolder {


    ImageView chatGroupChattingRoomYouPic;
    TextView chatGroupChattingRoomYouName;
    TextView chatGroupChattingRoomYouText;
    TextView chatGroupChattingRoomMeText;

    public ChatGroupChattingRoomPostViewHolder(View itemView) {
        super(itemView);
        chatGroupChattingRoomYouPic = (ImageView) itemView.findViewById(R.id.chatGroupChattingRoomYouPic);
        chatGroupChattingRoomYouName = (TextView) itemView.findViewById(R.id.chatGroupChattingRoomYouName);
        chatGroupChattingRoomYouText = (TextView) itemView.findViewById(R.id.chatGroupChattingRoomYouText);
        chatGroupChattingRoomMeText = (TextView) itemView.findViewById(R.id.chatGroupChattingRoomMeText);
    }

    public void setData(Post post) {
        chatGroupChattingRoomYouPic.setImageDrawable(post.postChatGroupChattingRoomYouPic);
        chatGroupChattingRoomYouName.setText(post.postChatGroupChattingRoomYouName);
        chatGroupChattingRoomYouText.setText(post.postChatGroupChattingRoomYouText);
        chatGroupChattingRoomMeText.setText(post.postChatGroupChattingRoomMeText);

    }

}