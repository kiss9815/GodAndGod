package com.juntcompany.godandgod.Main.Profile.MyProfile;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.Data.sendData;
import com.juntcompany.godandgod.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiseong on 2016-05-10.
 */
public class ProfileMyProfileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    List<Post> items = new ArrayList<Post>();

    public void add(Post post) {
        items.add(post);
        notifyDataSetChanged();
    }


    public void addAll(List<Post> posts) {
        items.addAll(posts);
        notifyDataSetChanged();
    }

    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_ITEM = 100;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_HEADER: {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_myprofile_post_header, parent, false);
                return new ProfileMyProfilePostHeaderViewHolder(view);
            }
            default:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_myprofile_post, parent, false);
                return new ProfileMyProfilePostViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position > 0) {
            int index = position - 1; // 헤더는 아이템이 하나므로
            ((ProfileMyProfilePostViewHolder) holder).setData((sendData) items.get(index));
        }
    }



    @Override
    public int getItemViewType(int position) {
        if (position < 1) {
            return VIEW_TYPE_HEADER;
        }
        return VIEW_TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return items.size() + 1; // 헤더 포지션 1 더함
    }
}
