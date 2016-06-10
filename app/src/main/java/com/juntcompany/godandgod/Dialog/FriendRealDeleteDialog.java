package com.juntcompany.godandgod.Dialog;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgod.Main.FriendInfo.FriendInfoActivity;
import com.juntcompany.godandgod.R;

public class FriendRealDeleteDialog extends Activity {
    public static Activity friendrealdeletedialog;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        friendrealdeletedialog = FriendRealDeleteDialog.this;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_friend_real_delete_dialog);
        Activity view = FriendInfoActivity.friendInfoActivity;
        TextView cn = (TextView) findViewById(R.id.cenceltext);
        final TextView oktv = (TextView) findViewById(R.id.Oktext);
        final ImageView userAdd1 = (ImageView) view.findViewById(R.id.userAdd1);
        final ImageView userMessage = (ImageView) view.findViewById(R.id.userMessage);

        cn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        oktv.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                userAdd1.setBackgroundResource(R.drawable.useradd);
                userMessage.setBackgroundResource(R.drawable.message);
                finish();
            }
        });
    }
}

