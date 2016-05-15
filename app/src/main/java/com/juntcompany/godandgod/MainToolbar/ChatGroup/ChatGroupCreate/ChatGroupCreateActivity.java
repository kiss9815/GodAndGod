package com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupCreate;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.juntcompany.godandgod.Main.Home.HomeFragment;
import com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupCreate.ChatGroupCreateBottom.ChatGroupCreateBottomFragment;
import com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupCreate.ChatGroupCreateMiddle.ChatGroupCreateMiddleFragment;
import com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupCreate.ChatGroupCreateTop.ChatGroupCreateTopFragment;
import com.juntcompany.godandgod.R;

public class ChatGroupCreateActivity extends AppCompatActivity {

    public static Activity createChatActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_group_create);


        createChatActivity = ChatGroupCreateActivity.this;
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        View titleView = getLayoutInflater().inflate(R.layout.toolbar_chat_group_create, null);
        actionBar.setCustomView(titleView);

        ChatGroupCreateTopFragment tf = new ChatGroupCreateTopFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.ChatGroupCreateTopContainer, tf)
                .commit();
        ChatGroupCreateMiddleFragment mf = new ChatGroupCreateMiddleFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.ChatGroupCreateMiddleContainer, mf)
                .commit();
        ChatGroupCreateBottomFragment bf = new ChatGroupCreateBottomFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.ChatGroupCreateBottomContainer, bf)
                .commit();
    }
}
