package com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupCreate.ChatGroupCreateMiddle;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupChattingRoom.ChatGroupChattingRoomActivity;
import com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupCreate.ChatGroupCreateActivity;
import com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupCreate.ChatGroupCreateBottom.ChatGroupCreateBottomAdapter;
import com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupCreate.ChatGroupCreateBottom.ChatGroupCreateBottomFragment;
import com.juntcompany.godandgod.R;

public class ChatGroupCreateMiddleFragment extends Fragment {


    public ChatGroupCreateMiddleFragment() {
        // Required empty public constructor
    }

    Context context;
   public static int itemPosition;
    RecyclerView recyclerView;
   public static ChatGroupCreateMiddleAdapter mAdapter;

    public static int VIEW_TYPE_ITEM = 10;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //추가
        View view = inflater.inflate(R.layout.fragment_chat_group_create_middle, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mAdapter = new ChatGroupCreateMiddleAdapter();
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnItemTouchListener(new MainActivity.RecyclerTouchListener(context, recyclerView, new MainActivity.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                final RelativeLayout createInputUserDelete = (RelativeLayout) view.findViewById(R.id.createGroupInputUser);
//                final TextView emptyUser = (TextView)view.findViewById(R.id.emptyInputUserText);
                itemPosition = position;
                createInputUserDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (VIEW_TYPE_ITEM >= 0) {

                            mAdapter.items.remove(itemPosition);
                            mAdapter.notifyItemRemoved(itemPosition);

                        } else {
                            return;
                        }
                    }
                });
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



}
