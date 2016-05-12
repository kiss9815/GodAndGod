package com.juntcompany.godandgod.MainToolbar.ChatGroup;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.MainToolbar.ChatMessage.ChatMessageAdapter;
import com.juntcompany.godandgod.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatGroupFragment extends Fragment {


    public ChatGroupFragment() {
        // Required empty public constructor
    }


    RecyclerView recyclerView;
    ChatGroupAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //추가
        View view = inflater.inflate(R.layout.fragment_chat_group, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        mAdapter = new ChatGroupAdapter();
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        initData();
        return view;



        //추가
        // return inflater.inflate(R.layout.fragment_love, container, false);
    }
    private void initData(){
        for(int i=0; i<1; i++) {
            Post post = new Post();
            post.postChatLeftGroupPicture = getResources().getDrawable(R.drawable.gnd);
            post.postChatLeftGroupName = "GnD";
            post.postChatLeftGroupUser = "김세종 외 1명";
            post.postChatRightGroupPicture = getResources().getDrawable(R.drawable.groupnew);
            post.postChatRightGroupName = "새 그룹";
            post.postChatRightGroupUser = "그룹 만들기";
            mAdapter.add(post);
        }

    }


}
