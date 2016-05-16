package com.juntcompany.godandgod.Main.Friend.FriendRequest.FriendRequestTop;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.Main.Friend.FriendRequest.FriendRequestBottom.FriendRequestBottomAdapter;
import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.R;

public class FriendRequestTopFragment extends Fragment {


    public FriendRequestTopFragment() {
        // Required empty public constructor
    }

    Context context;
    int itemPosition;

    RecyclerView recyclerView;
    FriendRequestTopAdapter mAdapter;

    public static final int VIEW_TYPE_HEADER = 0;
    public static final int VIEW_TYPE_ITEM = VIEW_TYPE_HEADER + 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //추가
        View view = inflater.inflate(R.layout.fragment_friend_request_top, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mAdapter = new FriendRequestTopAdapter();
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        //

        recyclerView.addOnItemTouchListener(new MainActivity.RecyclerTouchListener(context, recyclerView, new MainActivity.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                final TextView deleteMsg = (TextView)view.findViewById(R.id.deleteMessage);
                final Button deleteRequest = (Button) view.findViewById(R.id.requestDelete);
                final Button okRequest = (Button) view.findViewById(R.id.requestOk);
                itemPosition = position;
                if (itemPosition == VIEW_TYPE_HEADER) {
                    return;

                } else {
                    deleteRequest.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (itemPosition > VIEW_TYPE_HEADER) {
                                okRequest.setVisibility(View.GONE);
                                deleteRequest.setVisibility(View.GONE);
                                deleteMsg.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                }
                Log.e("recycler", String.valueOf(position));


            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        //
        initData();


        return view;


        //추가
        // return inflater.inflate(R.layout.fragment_love, container, false);
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            Post post = new Post();
            if (i == VIEW_TYPE_HEADER) {
                post.postFriendRequestTopHeader = "친구 요청" + i;
            }
            else {
                post.postFriendRequestFriendPicture = getResources().getDrawable(R.drawable.fillheart);
                post.postFriendRequestFriendName = "요청" + i;
                post.postFriendRequestFriendReligion = "종교";
            }
            mAdapter.add(post);
        }

    }


    ActionBar actionBar;

    @Override
    public void onResume() {
        super.onResume();
        actionBar = ((MainActivity) getActivity()).getSupportActionBar();

        View view = actionBar.getCustomView();
//        Button btn = (Button)view.findViewById(R.id.buttonChat);
//        btn.setVisibility(View.VISIBLE);


    }

}