package com.juntcompany.godandgod.Dialog;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.juntcompany.godandgod.R;

public class FriendRealDeleteDialog extends Activity {
    public static Activity friendrealdeletedialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        friendrealdeletedialog = FriendRealDeleteDialog.this;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_friend_real_delete_dialog);
    }
}
