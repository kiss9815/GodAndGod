package com.juntcompany.godandgod.MainToolbar.ChatGroup;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupChattingRoom.ChatGroupChattingRoomActivity;
import com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupCreate.ChatGroupCreateActivity;
import com.juntcompany.godandgod.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatGroupFragment extends Fragment {


    public ChatGroupFragment() {
        // Required empty public constructor
    }

    Context context;
    int itemPosition;
    RecyclerView recyclerView;
   public static ChatGroupAdapter mAdapter;

    public static final int VIEW_TYPE_HEADER = 0;
    public static final int VIEW_TYPE_ITEM = 100;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //추가
        View view = inflater.inflate(R.layout.fragment_chat_group, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mAdapter = new ChatGroupAdapter();
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnItemTouchListener(new MainActivity.RecyclerTouchListener(context, recyclerView, new MainActivity.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                final TableLayout groupNum1 = (TableLayout) view.findViewById(R.id.groupNum1);
                final TableLayout groupNum2 = (TableLayout) view.findViewById(R.id.groupNum2);
                final Button createGroup = (Button) view.findViewById(R.id.createGroupButton);

                itemPosition = position;
                if (itemPosition == VIEW_TYPE_HEADER) {
                    createGroup.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity.main.getApplicationContext(), ChatGroupCreateActivity.class);
                            startActivity(intent);
                        }
                    });
                    return;

                } else {
                    groupNum1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity.main.getApplicationContext(), ChatGroupChattingRoomActivity.class);
                            startActivity(intent);
                        }
                    });
                    groupNum2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity.main.getApplicationContext(), ChatGroupCreateActivity.class);
                            startActivity(intent);
                        }
                    });
                }
                Log.e("recycler", String.valueOf(position));


            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        return view;


        //추가
        // return inflater.inflate(R.layout.fragment_love, container, false);
    }

    private void initData() {
            Post post = new Post();
            post.postChatLeftGroupPicture = getResources().getDrawable(R.drawable.titleicon);
            post.postChatLeftGroupName = "GnD";
            post.postChatLeftGroupUser = "김세종 외 1명";
            post.postChatRightGroupPicture = getResources().getDrawable(R.drawable.groupnew);
            post.postChatRightGroupName = "새 그룹";
            post.postChatRightGroupUser = "그룹 만들기";
            mAdapter.add(post);

    }


}
