package com.juntcompany.godandgod.Main.Video;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.Main.Love.LoveAdapter;
import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {


    public VideoFragment() {
        // Required empty public constructor
    }
    RecyclerView recyclerView;
    VideoAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_love, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        mAdapter = new VideoAdapter();
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        initData();
        return view;


        // return inflater.inflate(R.layout.fragment_video, container, false);
    }

    private void initData(){
        for(int i=0; i<10; i++) {
            Post post = new Post();
            post.postVideoPic = getResources().getDrawable(R.drawable.heart);
            post.postVideoName = "GnD가 만들어지는 과정";
            post.postVideoUser = "GnD";
            post.postVideoviewCount = "10만";
            post.postVideoUpdateTime = "2";
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
