package com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupChattingRoom;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.Data.receiveData;
import com.juntcompany.godandgod.Data.sendData;
import com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupCreate.ChatGroupCreateBottom.ChatGroupCreateBottomFragment;
import com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupCreate.ChatGroupCreateBottom.ChatGroupCreateBottomPostViewHolder;
import com.juntcompany.godandgod.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiseong on 2016-05-16.
 */
public class ChatGroupChattingRoomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    List<Post> items = new ArrayList<Post>();

    public void add(Post post) {
        items.add(post);
        notifyDataSetChanged();
    }


    public void addAll(List<Post> posts) {
        items.addAll(posts);
        notifyDataSetChanged();
    }

    private static final int VIEW_TYPE_RECEIVE = 0;
    private static final int VIEW_TYPE_SEND = 1;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = null;
        switch (viewType) {
            case VIEW_TYPE_RECEIVE:
                view = inflater.inflate(R.layout.view_chatreceive, parent, false);
                return new ChatGroupChattingRoomReceiveViewHolder(view);
            case VIEW_TYPE_SEND:
                view = inflater.inflate(R.layout.view_chatsend, parent, false);
                return new ChatGroupChattingRoomSendPostViewHolder(view);
        }
        return null;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case VIEW_TYPE_RECEIVE:
                ((ChatGroupChattingRoomReceiveViewHolder) holder).setReceiveData((receiveData) items.get(position));
                break;
            case VIEW_TYPE_SEND:
                ((ChatGroupChattingRoomSendPostViewHolder) holder).setSendData((sendData) items.get(position));
                break;

        }
    }



    @Override
    public int getItemViewType(int position) {
        Post data = items.get(position);
        if(data instanceof receiveData){
            return VIEW_TYPE_RECEIVE;
        }else if(data instanceof sendData){
            return VIEW_TYPE_SEND;
        }

        return super.getItemViewType(position);

    }
    @Override
    public int getItemCount() {
        return items.size(); // 헤더 포지션 1 더함
    }
}