package com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupChattingRoom;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.Data.sendData;
import com.juntcompany.godandgod.R;

/**
 * Created by Jiseong on 2016-05-23.
 */
public class ChatGroupChattingRoomSendPostViewHolder extends RecyclerView.ViewHolder {
    ImageView chatGroupChattingRoomMePic;
    TextView chatGroupChattingRoomMeName;
    TextView chatGroupChattingRoomMeText;

    public ChatGroupChattingRoomSendPostViewHolder(View itemView) {
        super(itemView);
        chatGroupChattingRoomMePic = (ImageView) itemView.findViewById(R.id.chatGroupChattingRoomMePic);
        chatGroupChattingRoomMeName = (TextView) itemView.findViewById(R.id.chatGroupChattingRoomMeName);
        chatGroupChattingRoomMeText = (TextView) itemView.findViewById(R.id.chatGroupChattingRoomMeText);
    }

    public void setSendData(sendData sendData) {
        chatGroupChattingRoomMePic.setImageDrawable(sendData.postChatGroupChattingRoomMePic);
        chatGroupChattingRoomMeName.setText(sendData.postChatGroupChattingRoomMeName);
        chatGroupChattingRoomMeText.setText(sendData.postChatGroupChattingRoomMeText);

    }
}
