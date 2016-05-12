package com.juntcompany.godandgod.Main.Friend.FriendRequest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiseong on 2016-05-12.
 */
public class FriendRequestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    List<Post> items = new ArrayList<Post>();

    public void add(Post post) {
        items.add(post);
        notifyDataSetChanged();
    }


    public void addAll(List<Post> posts) {
        items.addAll(posts);
        notifyDataSetChanged();
    }

    private static final int VIEW_TYPE_TOP_HEADER = 0;
    private static final int VIEW_TYPE_TOP_ITEM = 1;
    private static final int VIEW_TYPE_BOTTOM_HEADER = 10;
    private static final int VIEW_TYPE_BOTTOM_ITEM = 100;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (VIEW_TYPE_TOP_HEADER == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_friend_request_post_top_header, parent, false);
            return new FriendRequestPostTopHeaderViewHolder(view);
        } else if (VIEW_TYPE_TOP_ITEM == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_friend_request_post_top, parent, false);
            return new FriendRequestPostTopViewHolder(view);
        } else if (VIEW_TYPE_BOTTOM_HEADER == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_friend_request_post_bottom_header, parent, false);
            return new FriendRequestPostBottomHeaderViewHolder(view);
        } else if (VIEW_TYPE_BOTTOM_ITEM == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_friend_request_post_bottom, parent, false);
            return new FriendRequestPostBottomViewHolder(view);
        }
        return null;
    }

    int top_header = 0;
    int bottom_header = 10;

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (position > top_header && position < bottom_header) {
            int index = position - 1;
            ((FriendRequestPostTopViewHolder) holder).setData(items.get(index));
        }
        else if (position > bottom_header) {
            int index = position - 2;
            ((FriendRequestPostBottomViewHolder) holder).setData(items.get(index));
        }
    }


    @Override
    public int getItemViewType(int position) {
        if (position == top_header) {
            return VIEW_TYPE_TOP_HEADER;
        } else if (position > top_header && position < bottom_header) {
            return VIEW_TYPE_TOP_ITEM;
        } else if (position == bottom_header) {
            return VIEW_TYPE_BOTTOM_HEADER;
        } else if (position > bottom_header) {
            return VIEW_TYPE_BOTTOM_ITEM;
        }
        return VIEW_TYPE_BOTTOM_ITEM;
    }

    @Override
    public int getItemCount() {
        return items.size() + 1; // 헤더 포지션 1 더함
    }
}
