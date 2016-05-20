package com.juntcompany.godandgod.Dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.juntcompany.godandgod.R;

public class EqualDialogActivity extends Activity {
    public static Activity dialogActivity;
    public static Activity helperActvity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog);
        dialogActivity = EqualDialogActivity.this;
        final TextView ntn = (TextView) findViewById(R.id.refind);
        ntn.setOnClickListener(new View.OnClickListener() {

            // TextView changeTop = (TextView) findViewById(R.id.changeTextTop);
            // TextView changeBottom = (TextView) findViewById(R.id.changeTextBottom);
            // changeTop.setText("이메일");changeBottom.setText("이메일");


            @Override
            public void onClick(View v) {
                finish();


            }
        });

    }


}
