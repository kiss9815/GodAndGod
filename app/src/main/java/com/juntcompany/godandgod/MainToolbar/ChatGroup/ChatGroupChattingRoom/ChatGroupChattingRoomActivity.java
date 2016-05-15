package com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupChattingRoom;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TableRow;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupCreate.ChatGroupCreateBottom.ChatGroupCreateBottomAdapter;
import com.juntcompany.godandgod.R;

public class ChatGroupChattingRoomActivity extends AppCompatActivity {
    Context context;
    int itemPosition;
    RecyclerView recyclerView;
    ChatGroupChattingRoomAdapter mAdapter;

    public static int VIEW_TYPE_ITEM = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_group_chatting_room);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new ChatGroupChattingRoomAdapter();
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

//        recyclerView.addOnItemTouchListener(new MainActivity.RecyclerTouchListener(context, recyclerView, new MainActivity.ClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//                final TableRow createInputUserDelete = (TableRow) view.findViewById(R.id.createGroupInputUser);
//                final CheckBox input = (CheckBox) view.findViewById(R.id.checkFriendInput);
//                itemPosition = position;
//                createInputUserDelete.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        if (input.isChecked()) {
//                            input.setChecked(false);
//                        } else {
//                            input.setChecked(true);
//                        }
//                    }
//                });
//                Log.e("recycler", String.valueOf(position));
//
//
//            }
//
//            @Override
//            public void onLongClick(View view, int position) {
//
//            }
//        }));


        initData();
    }

    private void initData() {
        TableRow you = (TableRow)findViewById(R.id.chatGroupChattingRoomYou);
        RelativeLayout me = (RelativeLayout)findViewById(R.id.chatGroupChattingRoomMe);
        for (int i = 0; i < 20; i++) {
            Post post = new Post();
            if(i%2 == 0)
            {
                post.postChatGroupChattingRoomYouPic = getResources().getDrawable(R.drawable.heart);
                post.postChatGroupChattingRoomYouName = "너"+i;
                post.postChatGroupChattingRoomYouText = "가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하" + i;
//                me.setVisibility(View.GONE);
            }
            else
            {
                post.postChatGroupChattingRoomMeText = "가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하" + i;
            }


            mAdapter.add(post);
        }

    }

}
