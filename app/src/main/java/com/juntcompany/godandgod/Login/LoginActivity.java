package com.juntcompany.godandgod.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.R;

public class LoginActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

    public void loginActivityClick(View v) {
        EditText id = (EditText)findViewById(R.id.idText);
        EditText pw = (EditText)findViewById(R.id.passwordText);

        switch (v.getId()) {
            case R.id.loginButton:
                if(id.getText().toString().equals( "jiseong369")) {
                    if(pw.getText().toString().equals("gksvks12")) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        MainActivity.loginStatus = true;
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); // 메인을 들어가면 메인 전에 실행했던 TASK 를 모두 삭제
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(this, "ID 또는 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(this, "ID 또는 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

}
