package com.juntcompany.godandgod.MainToolbar.ChatMessage;


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

/**
 * A simple {@link Fragment} subclass.
 */

public class ChatMessageFragment extends Fragment {


    public ChatMessageFragment() {
        // Required empty public constructor
    }


    RecyclerView recyclerView;
    ChatMessageAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //추가
        View view = inflater.inflate(R.layout.fragment_chat_message, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);

        mAdapter = new ChatMessageAdapter();
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
            post.postChatMessageRoomPicture = getResources().getDrawable(R.drawable.heart);
            post.postChatMessageRoomName = "GnD";
            post.postChatMessageRoomContent = "열심히 합시당.";
            post.postChatMessageUpdateTime = "2시간 전";
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