package com.juntcompany.godandgod.Dialog;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.juntcompany.godandgod.R;

public class NoEqualCodeActivity extends Activity {
    public static Activity dialogActivity2;
    public static Activity helperActvity;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_no_equal_code);
        dialogActivity2 = NoEqualCodeActivity.this;
        TextView ntn = (TextView) findViewById(R.id.rechallange);
        TextView rtn = (TextView) findViewById(R.id.retrans);
        ntn.setOnClickListener(new View.OnClickListener() {

            // TextView changeTop = (TextView) findViewById(R.id.changeTextTop);
            // TextView changeBottom = (TextView) findViewById(R.id.changeTextBottom);
            // changeTop.setText("이메일");changeBottom.setText("이메일");


            @Override
            public void onClick(View v) {
                finish();
            }
        });
        rtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(getApplicationContext(), "코드가 다시 전송되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
