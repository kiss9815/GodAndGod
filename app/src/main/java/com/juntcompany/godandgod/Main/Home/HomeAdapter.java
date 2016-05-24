package com.juntcompany.godandgod.Main.Home;

import android.preference.PreferenceActivity;
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
 * Created by EOM on 2016-04-29.
 */
public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    List<Post> items = new ArrayList<Post>();

    public void add(Post post) {
        items.add(post);
        notifyDataSetChanged();
    }


    public void addAll(List<Post> posts) {
        items.addAll(posts);
        notifyDataSetChanged();
    }

    private static final int VIEW_TYPE_ITEM = 0;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_home_post, parent, false);
        return new HomePostViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((HomePostViewHolder) holder).setData((sendData) items.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return VIEW_TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return items.size(); // 헤더 포지션 1 더함
    }
}
