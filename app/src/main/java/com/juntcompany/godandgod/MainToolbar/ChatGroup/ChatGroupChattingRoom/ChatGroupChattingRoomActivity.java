package com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupChattingRoom;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TableRow;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.Data.receiveData;
import com.juntcompany.godandgod.Data.sendData;
import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupCreate.ChatGroupCreateBottom.ChatGroupCreateBottomAdapter;
import com.juntcompany.godandgod.R;

public class ChatGroupChattingRoomActivity extends AppCompatActivity {
    Context context;
    int itemPosition;
    RecyclerView recyclerView;
    ChatGroupChattingRoomAdapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_group_chatting_room);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new ChatGroupChattingRoomAdapter();
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        Button chat = (Button) findViewById(R.id.chatOk);
        Button pictureAdd = (Button) findViewById(R.id.pictureAdd);
        final EditText inputChat = (EditText) findViewById(R.id.inputChat);
        pictureAdd.setOnClickListener(new View.OnClickListener() {
            String chatContent;

            @Override
            public void onClick(View v) {
                chatContent = inputChat.getText().toString();
                receiveData receiveData = new receiveData();
                receiveData.postChatGroupChattingRoomYouPic = getResources().getDrawable(R.drawable.heart);
                receiveData.postChatGroupChattingRoomYouName = "상대방";
                receiveData.postChatGroupChattingRoomYouText = chatContent;
                mAdapter.add(receiveData);
                inputChat.setText("");
            }
        });
        chat.setOnClickListener(new View.OnClickListener() {
            String chatContent;

            @Override
            public void onClick(View v) {
                chatContent = inputChat.getText().toString();
                sendData sendData = new sendData();
                sendData.postChatGroupChattingRoomMePic = getResources().getDrawable(R.drawable.titleicon);
                sendData.postChatGroupChattingRoomMeName = "나";
                sendData.postChatGroupChattingRoomMeText = chatContent;
                mAdapter.add(sendData);
                inputChat.setText("");
            }
        });

    }


}
