package com.juntcompany.godandgod.Dialog;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.juntcompany.godandgod.Login.LoginHelper.HelperActivity;
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
        TextView ntn = (TextView) findViewById(R.id.refind);
        TextView ctt = (TextView) findViewById(R.id.changeTextTop);
        TextView ctb = (TextView) findViewById(R.id.changeTextBottom);
        Button embutton = (Button) findViewById(R.id.buttonNext);

        if(HelperActivity.helpStatue == 0)
        {
            ctt.setText("휴대폰 번호");
            ctb.setText("휴대폰 번호");
        }
        else if(HelperActivity.helpStatue == 1)
        {
            ctt.setText("이메일 주소");
            ctb.setText("이메일 주소");
        }
        ntn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();

            }
        });


    }


}
