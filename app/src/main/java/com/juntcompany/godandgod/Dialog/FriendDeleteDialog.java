package com.juntcompany.godandgod.Dialog;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.juntcompany.godandgod.R;

public class FriendDeleteDialog extends Activity {
    public static Activity frienddeletedialog ;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_friend_delete_dialog);
        frienddeletedialog = FriendDeleteDialog.this;
        TextView tv = (TextView) findViewById(R.id.deletefriend);

        tv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FriendRealDeleteDialog.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
