package com.juntcompany.godandgod.Main.Friend.FriendRequest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.R;

public class FriendRequestFragment extends Fragment {


    public FriendRequestFragment() {
        // Required empty public constructor
    }


    RecyclerView recyclerView;
    FriendRequestAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //추가
        View view = inflater.inflate(R.layout.fragment_friend_request, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        mAdapter = new FriendRequestAdapter();
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        initData();
        return view;



        //추가
        // return inflater.inflate(R.layout.fragment_love, container, false);
    }

    private void initData(){
        for(int i=0; i<20; i++) {
            Post post = new Post();
            post.postFriendRequestFriendPicture = getResources().getDrawable(R.drawable.emptyheart);
            post.postFriendRequestFriendName = "요청";
            post.postFriendRequestFriendReligion = "종교";
            post.postFriendPushFriendPicture = getResources().getDrawable(R.drawable.fillheart);
            post.postFriendPushFriendName = "추천";
            post.postFriendPushFriendReligion = "종교";

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
