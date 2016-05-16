package com.juntcompany.godandgod.Main.Friend.FriendRequest.FriendRequestBottom;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.Main.Friend.FriendList.FriendListPostHeaderViewHolder;
import com.juntcompany.godandgod.Main.Friend.FriendList.FriendListPostViewHolder;
import com.juntcompany.godandgod.Main.Friend.FriendRequest.FriendRequestTop.FriendRequestPostTopHeaderViewHolder;
import com.juntcompany.godandgod.Main.Friend.FriendRequest.FriendRequestTop.FriendRequestPostTopViewHolder;
import com.juntcompany.godandgod.Main.Friend.FriendRequest.FriendRequestTop.FriendRequestTopFragment;
import com.juntcompany.godandgod.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiseong on 2016-05-12.
 */

public class FriendRequestBottomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


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
        switch (viewType) {
            case FriendRequestBottomFragment.VIEW_TYPE_HEADER: {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_friend_request_post_bottom_header, parent, false);
                return new FriendRequestPostBottomHeaderViewHolder(view);
            }
            default:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_friend_request_post_bottom, parent, false);
                return new FriendRequestPostBottomViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == FriendRequestBottomFragment.VIEW_TYPE_HEADER) {
            ((FriendRequestPostBottomHeaderViewHolder) holder).setData(items.get(position));
        } else {
            ((FriendRequestPostBottomViewHolder) holder).setData(items.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position < 1) {
            return FriendRequestBottomFragment.VIEW_TYPE_HEADER;
        }
        return FriendRequestBottomFragment.VIEW_TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return items.size(); // 헤더 포지션 1 더함
    }
}
