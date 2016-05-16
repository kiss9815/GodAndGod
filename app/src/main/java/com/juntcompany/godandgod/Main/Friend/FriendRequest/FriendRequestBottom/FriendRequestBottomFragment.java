package com.juntcompany.godandgod.Main.Friend.FriendRequest.FriendRequestBottom;

import android.content.Context;
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
import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.R;


public class FriendRequestBottomFragment extends Fragment {


    public FriendRequestBottomFragment() {
        // Required empty public constructor
    }

    Context context;
    int itemPosition;

    RecyclerView recyclerView;
    FriendRequestBottomAdapter mAdapter;

    public static final int VIEW_TYPE_HEADER = 0;
    public static final int VIEW_TYPE_ITEM = VIEW_TYPE_HEADER + 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //추가
        View view = inflater.inflate(R.layout.fragment_friend_request_bottom, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mAdapter = new FriendRequestBottomAdapter();
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        //
        recyclerView.addOnItemTouchListener(new MainActivity.RecyclerTouchListener(context, recyclerView, new MainActivity.ClickListener() {
            @Override
            public void onClick(final View view, int position) {
                final Button deletePush = (Button) view.findViewById(R.id.pushDelete);
                final Button okPush = (Button) view.findViewById(R.id.pushOk);
                final TextView deleteMsg = (TextView)view.findViewById(R.id.deleteMessage);
                itemPosition = position;
                if (itemPosition == VIEW_TYPE_HEADER) {
                    return;
                } else if (itemPosition > VIEW_TYPE_HEADER) {
                    deletePush.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (itemPosition > VIEW_TYPE_HEADER) {
                                okPush.setVisibility(View.GONE);
                                deletePush.setVisibility(View.GONE);
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
                post.postFriendRequestBottomHeader = "친구 추천" + i;
            } else {
                post.postFriendPushFriendPicture = getResources().getDrawable(R.drawable.emptyheart);
                post.postFriendPushFriendName = "추천" + i;
                post.postFriendPushFriendReligion = "종교";
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