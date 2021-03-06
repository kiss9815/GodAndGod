package com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupCreate.ChatGroupCreateBottom;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiseong on 2016-05-15.
 */
public class ChatGroupCreateBottomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    List<Post> items = new ArrayList<Post>();

    public void add(Post post) {
        items.add(post);
        notifyDataSetChanged();
    }


    public void addAll(List<Post> posts) {
        items.addAll(posts);
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_chat_group_create_bottom_post, parent, false);
        return new ChatGroupCreateBottomPostViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ChatGroupCreateBottomPostViewHolder) holder).setData(items.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return ChatGroupCreateBottomFragment.VIEW_TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return items.size(); // 헤더 포지션 1 더함
    }

}