package com.juntcompany.godandgod.Main.Live;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiveFragment extends Fragment {


    public LiveFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);
    }

    RecyclerView recyclerView;
    LiveAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_live, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mAdapter = new LiveAdapter();
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        initData();
        return view;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_live, container, false);
    }

    private void initData(){
        for(int i=0; i<10; i++) {
            Post post = new Post();
            post.postLivePicture = getResources().getDrawable(R.drawable.gnd);
            post.postLiveName = "생)GnD가 만들어지는 Live";
            post.postLiveUser = "GnD";
            post.postLiveViewCount = "10000";
            mAdapter.add(post);
        }

    }


    ActionBar actionBar;

    @Override
    public void onResume() {
        super.onResume();
        actionBar = ((MainActivity) getActivity()).getSupportActionBar();

        View view = actionBar.getCustomView();
//        Button btn = (Button)view.findViewById(R.id.buttonChat);
//        btn.setVisibility(View.GONE);

//        Button buttonStar = new Button(getContext());
//        buttonStar.setBackgroundResource(android.R.drawable.btn_star);


    }


}
