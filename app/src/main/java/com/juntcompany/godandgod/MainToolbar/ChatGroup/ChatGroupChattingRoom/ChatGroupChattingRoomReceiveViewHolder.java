package com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupChattingRoom;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.Data.receiveData;
import com.juntcompany.godandgod.R;

/**
 * Created by Jiseong on 2016-05-23.
 */
public class ChatGroupChattingRoomReceiveViewHolder extends RecyclerView.ViewHolder {


    ImageView chatGroupChattingRoomYouPic;
    TextView chatGroupChattingRoomYouName;
    TextView chatGroupChattingRoomYouText;

    public ChatGroupChattingRoomReceiveViewHolder(View itemView) {
        super(itemView);
        chatGroupChattingRoomYouPic = (ImageView) itemView.findViewById(R.id.chatGroupChattingRoomYouPic);
        chatGroupChattingRoomYouName = (TextView) itemView.findViewById(R.id.chatGroupChattingRoomYouName);
        chatGroupChattingRoomYouText = (TextView) itemView.findViewById(R.id.chatGroupChattingRoomYouText);
    }

    public void setReceiveData(receiveData receiveData) {
        chatGroupChattingRoomYouPic.setImageDrawable(receiveData.postChatGroupChattingRoomYouPic);
        chatGroupChattingRoomYouName.setText(receiveData.postChatGroupChattingRoomYouName);
        chatGroupChattingRoomYouText.setText(receiveData.postChatGroupChattingRoomYouText);

    }
}
