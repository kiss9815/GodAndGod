package com.juntcompany.godandgod.Main.Friend.FriendList;

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
import com.juntcompany.godandgod.Main.Love.LoveAdapter;
import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.R;

public class FriendListFragment extends Fragment {


    public FriendListFragment() {
        // Required empty public constructor
    }

    Context context;
    int itemPosition;
    RecyclerView recyclerView;
    FriendListAdapter mAdapter;

    public static final int VIEW_TYPE_HEADER = 0;
    public static final int VIEW_TYPE_ITEM = 100;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //추가
        View view = inflater.inflate(R.layout.fragment_friend_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mAdapter = new FriendListAdapter();
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        initData();


        recyclerView.addOnItemTouchListener(new MainActivity.RecyclerTouchListener(context, recyclerView, new MainActivity.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                final TextView deleteMsg = (TextView) view.findViewById(R.id.deleteMessage);
                final Button deleteFriend = (Button) view.findViewById(R.id.friendListFriendDelete);
                itemPosition = position;
                if (itemPosition == VIEW_TYPE_HEADER) {
                    return;

                } else {
                    deleteFriend.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (itemPosition > VIEW_TYPE_HEADER) {
                                deleteFriend.setVisibility(View.GONE);
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


        //추가
        // return inflater.inflate(R.layout.fragment_love, container, false);
        return view;
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            Post post = new Post();
            post.postFriendListFriendPicture = getResources().getDrawable(R.drawable.emptyheart);
            post.postFriendListFriendName = "가나다";
            post.postFriendListFriendArea = "서울";
            post.postFriendListFriendReligion = "가가";
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
