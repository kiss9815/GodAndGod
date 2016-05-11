package com.juntcompany.godandgod.Main.Profile.MyProfile;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.R;

public class ProfileMyprofileFragment extends Fragment {

    public ProfileMyprofileFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    ProfileMyProfileAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mAdapter = new ProfileMyProfileAdapter();
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        initData();
        return view;
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            Post post = new Post();
            post.postMyProfileUserPicture = getResources().getDrawable(R.mipmap.ic_launcher);
            post.postMyProfileUserName = "GnD";
            post.postMyProfileTextTime = "1시간 전";
            post.postMyProfileContent = "열심히 일하는 중이다";
            post.postMyProfileUserLikeNum = "100";
            post.postMyProfileUserCommentNum = "10000";
            mAdapter.add(post);
        }

    }

}
