package com.juntcompany.godandgod.Main.Search;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.R;

/**
 * Created by Jiseong on 2016-05-12.
 */
public class SearchPostTopViewHolder extends RecyclerView.ViewHolder {


    ImageView searchUserPicture;
    TextView searchUserName;
    TextView searchUserReligion;

    public SearchPostTopViewHolder(View itemView) {
        super(itemView);
        searchUserPicture = (ImageView) itemView.findViewById(R.id.searchUserPicture);
        searchUserName = (TextView) itemView.findViewById(R.id.searchUserName);
        searchUserReligion = (TextView) itemView.findViewById(R.id.searchUserReligion);
    }

    public void setData(Post post) {
        searchUserPicture.setImageDrawable(post.postSearchUserPicture);
        searchUserName.setText(post.postSearchUserName);
        searchUserReligion.setText(post.postSearchUserReligion);

    }

}