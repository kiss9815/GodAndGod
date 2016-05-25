package com.juntcompany.godandgod.Dialog;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.juntcompany.godandgod.R;

public class MyProfileUpdateDialog extends Activity {
    public static Activity myprofileupdatedialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myprofileupdatedialog = MyProfileUpdateDialog.this;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_my_profile_update_dialog);
    }
}
