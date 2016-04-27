package com.juntcompany.godandgod.Main.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.R;

public class LoginActivity extends AppCompatActivity {
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
                        MainActivity.loginStatus = true;
                        finish();
                    }
                    else
                    {
                        pw.setText("");
                        Toast.makeText(this, "ID 또는 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    pw.setText("");
                    Toast.makeText(this, "ID 또는 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.loginHelp:
                Intent intent = new Intent(getApplicationContext(), LoginHelp.class);
                startActivity(intent);
                break;
        }
    }


}
