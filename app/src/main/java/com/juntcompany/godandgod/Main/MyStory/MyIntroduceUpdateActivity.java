package com.juntcompany.godandgod.Main.MyStory;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.juntcompany.godandgod.R;

public class MyIntroduceUpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_introduce_update);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("내소개");
        View titleView = getLayoutInflater().inflate(R.layout.toolbar_writestory, null);
        actionBar.setCustomView(titleView);
        final EditText ed = (EditText) findViewById(R.id.editText);
        final TextView tv = (TextView) findViewById(R.id.idText);

        ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                tv.setText(String.valueOf(ed.getText().toString().length()));
            }

            @Override
            public void afterTextChanged(Editable arg0) {

            }

        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    public void onBackPressed() {
        finish();
    }


}
