package com.juntcompany.godandgod.Dialog;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.juntcompany.godandgod.R;

public class ChatDeleteDialog extends Activity {
    public static Activity chatdeletedialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chatdeletedialog = ChatDeleteDialog.this ;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_chat_delete_dialog);
    }
}
