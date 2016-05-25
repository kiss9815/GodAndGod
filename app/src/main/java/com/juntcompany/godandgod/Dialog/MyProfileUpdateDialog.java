package com.juntcompany.godandgod.Dialog;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TableRow;
import android.widget.Toast;

import com.juntcompany.godandgod.Main.MyStory.MyIntroduceUpdateActivity;
import com.juntcompany.godandgod.Main.MyStory.MyStoryActivity;
import com.juntcompany.godandgod.R;

public class MyProfileUpdateDialog extends Activity {
    public static Activity myprofileupdatedialog;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myprofileupdatedialog = MyProfileUpdateDialog.this;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_my_profile_update_dialog);
        TableRow tb = (TableRow) findViewById(R.id.introduce);
        TableRow tb1 = (TableRow) findViewById(R.id.table1);

        tb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyIntroduceUpdateActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tb1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PictureActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
