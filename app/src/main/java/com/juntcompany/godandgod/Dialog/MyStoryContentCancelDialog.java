package com.juntcompany.godandgod.Dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.juntcompany.godandgod.R;

public class MyStoryContentCancelDialog extends Activity {
    public static Activity mystorycontentcanceldialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        mystorycontentcanceldialog = MyStoryContentCancelDialog.this;
        setContentView(R.layout.activity_my_story_content_cancel_dialog);
    }
}
