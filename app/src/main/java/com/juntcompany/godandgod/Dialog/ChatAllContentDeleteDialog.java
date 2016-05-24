package com.juntcompany.godandgod.Dialog;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.juntcompany.godandgod.R;

public class ChatAllContentDeleteDialog extends Activity {
    public static Activity chatallcontentdeletedialog ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        chatallcontentdeletedialog = ChatAllContentDeleteDialog.this;
        setContentView(R.layout.activity_chat_all_content_delete_dialog);
    }
}
