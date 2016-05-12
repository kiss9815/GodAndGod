package com.juntcompany.godandgod.Main.Search;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.Main.Friend.FriendRequest.FriendRequestPostBottomHeaderViewHolder;
import com.juntcompany.godandgod.Main.Friend.FriendRequest.FriendRequestPostBottomViewHolder;
import com.juntcompany.godandgod.Main.Friend.FriendRequest.FriendRequestPostTopHeaderViewHolder;
import com.juntcompany.godandgod.Main.Friend.FriendRequest.FriendRequestPostTopViewHolder;
import com.juntcompany.godandgod.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiseong on 2016-05-12.
 */
public class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


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
    private static final int VIEW_TYPE_BOTTOM_HEADER = 11;
    private static final int VIEW_TYPE_BOTTOM_ITEM = 12;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (VIEW_TYPE_TOP_HEADER == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_search_post_top_header, parent, false);
            return new SearchPostTopHeaderViewHolder(view);
        } else if (VIEW_TYPE_TOP_ITEM == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_search_post_top, parent, false);
            return new SearchPostTopViewHolder(view);
        } else if (VIEW_TYPE_BOTTOM_HEADER == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_search_post_bottom_header, parent, false);
            return new SearchPostBottomHeaderViewHolder(view);
        } else if (VIEW_TYPE_BOTTOM_ITEM == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_search_post_bottom, parent, false);
            return new SearchPostBottomViewHolder(view);
        }
        return null;
    }

    int top_header = 0;
    int bottom_header = 11;

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (position > top_header && position < bottom_header) {
            int index = position - 1;
            ((SearchPostTopViewHolder) holder).setData(items.get(index));
        }
        else if (position > bottom_header) {
            int index = position - 2;
            ((SearchPostBottomViewHolder) holder).setData(items.get(index));
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