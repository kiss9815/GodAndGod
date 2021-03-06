package com.juntcompany.godandgod.Main.FriendInfo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.Data.receiveData;
import com.juntcompany.godandgod.Data.sendData;
import com.juntcompany.godandgod.Dialog.FriendDeleteDialog;
import com.juntcompany.godandgod.Dialog.FriendRealDeleteDialog;
import com.juntcompany.godandgod.Dialog.NoFriendResultDialog;
import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.Main.Profile.MyProfile.ProfileMyProfileAdapter;
import com.juntcompany.godandgod.Main.Profile.ProfileFragment;
import com.juntcompany.godandgod.Main.Search.SearchActivity;
import com.juntcompany.godandgod.MainToolbar.ChatFragment;
import com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupChattingRoom.ChatGroupChattingRoomActivity;
import com.juntcompany.godandgod.R;

public class FriendInfoActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    public static FriendInfoAdapter mAdapter;
    Intent intent;
    Context context;
    int heartOn = 0;
    public static Activity friendInfoActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_info);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        friendInfoActivity = FriendInfoActivity.this;

        View titleView = getLayoutInflater().inflate(R.layout.toolbar_friendinfo, null);
        final RelativeLayout searchLayout = (RelativeLayout) titleView.findViewById(R.id.searchActivityMove);
        actionBar.setCustomView(titleView);
        actionBar.setCustomView(titleView);
        searchLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new FriendInfoAdapter();
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnItemTouchListener(new MainActivity.RecyclerTouchListener(context, recyclerView, new MainActivity.ClickListener() {
            @Override
            public void onClick(final View view, int position) {
                TableRow friendLikeBox = (TableRow) view.findViewById(R.id.friendLikeBox);
                final TextView myFriendUserLikeNum = (TextView) view.findViewById(R.id.myFriendUserLikeNum);
                final ImageView heartStatue = (ImageView) view.findViewById(R.id.heartStatue);
                final RelativeLayout rel1 = (RelativeLayout) findViewById(R.id.rel1);
                //final ImageView ima = (ImageView) view.findViewById(R.id.userAdd1);
                //final ImageView ima1 = (ImageView) view.findViewById(R.id.userMessage) ;
/*
                friendLikeBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (heartOn == 0) {
                            int num = Integer.parseInt(myFriendUserLikeNum.getText().toString()) + 1;
                            myFriendUserLikeNum.setText(String.valueOf(num));
                            heartStatue.setBackgroundResource(R.drawable.heart);
                            heartOn = 1;
                        } else {
                            int num = Integer.parseInt(myFriendUserLikeNum.getText().toString()) - 1;
                            myFriendUserLikeNum.setText(String.valueOf(num));
                            heartStatue.setBackgroundResource(R.drawable.fillheart);
                            heartOn = 0;
                        }

                    }
                });

*/


            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        ImageView userAdd1 = (ImageView) findViewById(R.id.userAdd1);
        ImageView userMessage = (ImageView) findViewById(R.id.userMessage);

        if (MainActivity.friendStatue) {
            MainActivity.friendStatue = false;
            userAdd1.setBackgroundResource(R.drawable.camera);
            userMessage.setBackgroundResource(R.drawable.camera);
        } else {
            MainActivity.friendStatue = true;
            userAdd1.setBackgroundResource(R.drawable.useradd);
            userMessage.setBackgroundResource(R.drawable.message);
        }
        initData();
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(0, 0);
    }

    public void friendaddClick(View v) {

        ImageView userAdd1 = (ImageView) findViewById(R.id.userAdd1);
        ImageView userMessage = (ImageView) findViewById(R.id.userMessage);

        switch (v.getId()) {
            case R.id.userAdd1:
                if (MainActivity.friendStatue) {
                    MainActivity.friendStatue = false;
                    userAdd1.setBackgroundResource(R.drawable.camera);
                    userMessage.setBackgroundResource(R.drawable.camera);

                } else {
                    MainActivity.friendStatue = true;
                    Intent intent = new Intent(getApplicationContext(), FriendDeleteDialog.class);
                    startActivity(intent);
                }
        }
    }


    public void messesClick(View v) {

        switch (v.getId()) {
            case R.id.userMessage: {
                if (MainActivity.friendStatue == false) {
                    Intent intent = new Intent(getApplicationContext(), ChatGroupChattingRoomActivity.class);
                    startActivity(intent);

                } else {
                    Intent intent = new Intent(getApplicationContext(), NoFriendResultDialog.class);
                    startActivity(intent);
                }
            }
        }
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            receiveData receiveData = new receiveData();
            receiveData.postMyFriendUserPicture = getResources().getDrawable(R.drawable.friendhome);
            receiveData.postMyFriendUserName = "이하" + i;
            receiveData.postMyFriendTextTime = i + "시간 전";
//            receiveData.postMyFriendContentPic = getResources().getDrawable(R.drawable.picture);
            receiveData.postMyFriendContent = "칼퇴를 위하여!! " + i;
            receiveData.postMyFriendUserLikeNum = "100" + i;
            receiveData.postMyFriendUserCommentNum = "20000000" + i;
            mAdapter.add(receiveData);
        }

    }
}

