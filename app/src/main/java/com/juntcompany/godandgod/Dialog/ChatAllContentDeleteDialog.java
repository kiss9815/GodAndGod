package com.juntcompany.godandgod.Dialog;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.juntcompany.godandgod.R;

public class ChatAllContentDeleteDialog extends Activity {
    public static Activity chatallcontentdeletedialog;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        chatallcontentdeletedialog = ChatAllContentDeleteDialog.this;
        setContentView(R.layout.activity_chat_all_content_delete_dialog);
        TextView tv1 = (TextView) findViewById(R.id.textView10);
        TextView tv2 = (TextView) findViewById(R.id.textView11);
        tv1.setOnClickListener(new View.OnClickListener() {
//
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChatDeleteDialog.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
