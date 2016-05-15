package com.juntcompany.godandgod.Main.MyStory;

import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.juntcompany.godandgod.R;

public class MyStoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_story);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("게시글");
        View titleView = getLayoutInflater().inflate(R.layout.toolbar_writestory, null);
        actionBar.setCustomView(titleView);

        EditText myStory = (EditText)findViewById(R.id.myStoryInput);
        myStory.addTextChangedListener(new TextWatcher() {
            ImageView hintImage = (ImageView)findViewById(R.id.hintImage);
            TextView InputOkStory = (TextView)findViewById(R.id.inputStoryOk);
            EditText myStory = (EditText)findViewById(R.id.myStoryInput);
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(myStory.getText().length() == 0)
                {
                    hintImage.setVisibility(View.VISIBLE);
                    InputOkStory.setFocusable(false);
                    InputOkStory.setTextColor(Color.GRAY);
                }
                else
                {
                    hintImage.setVisibility(View.GONE);
                    InputOkStory.setFocusable(true);
                    InputOkStory.setTextColor(Color.WHITE);
                }
            }


            @Override
            public void afterTextChanged(Editable arg0) {
                // 입력이 끝났을 때
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // 입력하기 전에
            }
        });;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
