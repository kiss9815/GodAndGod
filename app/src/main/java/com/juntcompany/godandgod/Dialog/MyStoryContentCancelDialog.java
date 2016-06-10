package com.juntcompany.godandgod.Dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.juntcompany.godandgod.Main.MyStory.MyStoryActivity;
import com.juntcompany.godandgod.R;

public class MyStoryContentCancelDialog extends Activity {
    public static Activity mystorycontentcanceldialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        mystorycontentcanceldialog = MyStoryContentCancelDialog.this;
        setContentView(R.layout.activity_my_story_content_cancel_dialog);
        TextView Clear = (TextView) findViewById(R.id.textdelet3);
        TextView delete = (TextView) findViewById(R.id.textdelet4);

        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        delete.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                MyStoryActivity.mystoryactivity.finish();
                finish();
            }
        });

    }
}
