package com.juntcompany.godandgod.Main.FriendInfo;

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
import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.Main.Profile.MyProfile.ProfileMyProfileAdapter;
import com.juntcompany.godandgod.Main.Profile.ProfileFragment;
import com.juntcompany.godandgod.Main.Search.SearchActivity;
import com.juntcompany.godandgod.MainToolbar.ChatFragment;
import com.juntcompany.godandgod.R;

public class FriendInfoActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    public static FriendInfoAdapter mAdapter;
Intent intent;
    Context context;
    int heartOn = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_info);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);


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
            public void onClick(View view, int position) {
                TableRow friendLikeBox = (TableRow) view.findViewById(R.id.friendLikeBox);
                final TextView myFriendUserLikeNum = (TextView) view.findViewById(R.id.myFriendUserLikeNum);
                final ImageView heartStatue = (ImageView) view.findViewById(R.id.heartStatue);
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

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        initData();
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(0, 0);
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            receiveData receiveData = new receiveData();
            receiveData.postMyFriendUserPicture = getResources().getDrawable(R.drawable.friendhome);
            receiveData.postMyFriendUserName = "이하" + i;
            receiveData.postMyFriendTextTime = i+"시간 전";
//            receiveData.postMyFriendContentPic = getResources().getDrawable(R.drawable.picture);
            receiveData.postMyFriendContent = "칼퇴를 위하여!! " + i;
            receiveData.postMyFriendUserLikeNum = "100" + i;
            receiveData.postMyFriendUserCommentNum = "20000000" + i;
            mAdapter.add(receiveData);
        }

    }
}

