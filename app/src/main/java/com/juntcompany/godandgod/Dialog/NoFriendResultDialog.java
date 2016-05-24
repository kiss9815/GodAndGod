package com.juntcompany.godandgod.Dialog;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.juntcompany.godandgod.R;

public class NoFriendResultDialog extends Activity {
    public static Activity nofriendrsultdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_no_friend_result_dialog);
        nofriendrsultdialog = NoFriendResultDialog.this;

    }
}
