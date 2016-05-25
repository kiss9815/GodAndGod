package com.juntcompany.godandgod.Dialog;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.juntcompany.godandgod.R;

public class ChatDeleteDialog extends Activity {
    public static Activity chatdeletedialog;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chatdeletedialog = ChatDeleteDialog.this;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_chat_delete_dialog);
        TextView tv = (TextView) findViewById(R.id.deletechat);

        tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChatAllContentDeleteDialog.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
