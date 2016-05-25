package com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupCreate.ChatGroupCreateBottom;

import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.Main.Profile.MyProfile.ProfileMyprofileFragment;
import com.juntcompany.godandgod.Main.Profile.ProfileMainFragment;
import com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupCreate.ChatGroupCreateMiddle.ChatGroupCreateMiddleAdapter;
import com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupCreate.ChatGroupCreateMiddle.ChatGroupCreateMiddleFragment;
import com.juntcompany.godandgod.R;

import java.util.ArrayList;

public class ChatGroupCreateBottomFragment extends Fragment {


    public ChatGroupCreateBottomFragment() {
        // Required empty public constructor
    }

    Context context;
    int itemPosition;
    RecyclerView recyclerView;
    public static ChatGroupCreateBottomAdapter mAdapter;
    public static ChatGroupCreateMiddleAdapter middleAdapter;

    public static ArrayList<Integer> checkUser = new ArrayList<>();

    public static int VIEW_TYPE_ITEM = 10;
    public static CheckBox input;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //추가
        View view = inflater.inflate(R.layout.fragment_chat_group_create_bottom, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mAdapter = new ChatGroupCreateBottomAdapter();
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnItemTouchListener(new MainActivity.RecyclerTouchListener(context, recyclerView, new MainActivity.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                final TableRow createInputUserDelete = (TableRow) view.findViewById(R.id.createGroupInputUser);
                input = (CheckBox) view.findViewById(R.id.checkFriendInput);
                final TextView inputFriendName = (TextView) view.findViewById(R.id.inputFriendName);
                final ImageView inputFriendPic = (ImageView) view.findViewById(R.id.inputFriendPic);
                itemPosition = position;
                createInputUserDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (input.isChecked()) {
                            input.setChecked(false);
                        } else {
                            input.setChecked(true);
                            Post post = new Post();
                            post.postCreateGroupInputUserPic = inputFriendPic.getDrawable();
                            post.postCreateGroupInputUserName = inputFriendName.getText().toString();
                            ChatGroupCreateMiddleFragment.mAdapter.add(post);
                            checkUser.add(itemPosition);
                        }
                    }
                });
                input.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Post post = new Post();
                        post.postCreateGroupInputUserPic = inputFriendPic.getDrawable();
                        post.postCreateGroupInputUserName = inputFriendName.getText().toString();
                        ChatGroupCreateMiddleFragment.mAdapter.add(post);
                        checkUser.add(itemPosition);
                    }
                });
                Log.e("recycler", String.valueOf(position));


            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        initData();
        return view;


        //추가
        // return inflater.inflate(R.layout.fragment_love, container, false);
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            Post post = new Post();
            post.postInputFriendPic = getResources().getDrawable(R.drawable.picture);
            post.postInputFriendName = "이하" + i;
            mAdapter.add(post);
        }

    }


}
