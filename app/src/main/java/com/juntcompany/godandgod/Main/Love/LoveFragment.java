package com.juntcompany.godandgod.Main.Love;


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
import com.juntcompany.godandgod.Main.Home.HomeAdapter;
import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoveFragment extends Fragment {


    public LoveFragment() {
        // Required empty public constructor
    }


    RecyclerView recyclerView;
    LoveAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //추가
        View view = inflater.inflate(R.layout.fragment_love, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        mAdapter = new LoveAdapter();
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        initData();
        return view;



        //추가
       // return inflater.inflate(R.layout.fragment_love, container, false);
    }

    private void initData(){
        for(int i=0; i<10; i++) {
            Post post = new Post();
            post.postLoveUserPicture = getResources().getDrawable(R.drawable.titleicon);
            post.postLoveUserName = "GnD";
            post.postLoveStatue = "님이 회원님의 게시물을 좋아합니다.";
            post.postLoveContent = "테스트 중입니다.";
            post.postLoveUpdateTime = "2시간 전";
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
