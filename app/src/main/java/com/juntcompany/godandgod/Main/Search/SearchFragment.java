package com.juntcompany.godandgod.Main.Search;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {


    public SearchFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);
    }

    RecyclerView recyclerView;
    SearchAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        mAdapter = new SearchAdapter();
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        initData();
        return view;
    }

    private void initData(){
        for(int i=0; i<12; i++) {
            Post post = new Post();
            post.postSearchUserPicture = getResources().getDrawable(R.drawable.emptyheart);
            post.postSearchUserName = "Heart";
            post.postSearchUserReligion = "무교";
            mAdapter.add(post);
        }

    }


    ActionBar actionBar;

    @Override
    public void onResume() {
        super.onResume();
//        Button btn = (Button)view.findViewById(R.id.buttonChat);
//        btn.setVisibility(View.GONE);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                getFragmentManager().popBackStack();
                actionBar.setDisplayHomeAsUpEnabled(false);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
