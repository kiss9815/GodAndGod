package com.juntcompany.godandgod.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.juntcompany.godandgod.Login.LoginHelper.HelperActivity;
import com.juntcompany.godandgod.Login.SignIn.SignInActivity;
import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.Main.backpress;
import com.juntcompany.godandgod.Manager.PropertyManager;
import com.juntcompany.godandgod.R;

public class LoginActivity extends AppCompatActivity {
    Intent intent;
    private backpress backPressCloseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        backPressCloseHandler = new backpress(this);
        getSupportActionBar().hide();
    }

    public void loginActivityClick(View v) {
        EditText id = (EditText) findViewById(R.id.idText);
        EditText pw = (EditText) findViewById(R.id.passwordText);
        CheckBox saveid = (CheckBox) findViewById(R.id.saveId);
        CheckBox autoLogin = (CheckBox) findViewById(R.id.autoLogin);

        switch (v.getId()) {
            case R.id.loginButton:
                if (id.getText().toString().equals("123")) {
                    if (pw.getText().toString().equals("123")) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        MainActivity.loginStatus = true;
                        if (saveid.isChecked()) {
                            PropertyManager.getInstance().setUserId(id.getText().toString());
                        } else {
                            PropertyManager.getInstance().setUserId("");
                        }

                        if (autoLogin.isChecked()) {
                            PropertyManager.getInstance().setUserId(id.getText().toString());
                            PropertyManager.getInstance().setPassword(pw.getText().toString());
                        } else {
                            PropertyManager.getInstance().setPassword("");
                        }
                        MainActivity.logout = false;
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); // 메인을 들어가면 메인 전에 실행했던 TASK 를 모두 삭제
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(this, "ID 또는 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "ID 또는 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.loginHelp:
                intent = new Intent(getApplicationContext(), HelperActivity.class);
                startActivity(intent);
                break;
            case R.id.signHelp:
                intent = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(intent);
                break;
        }

    }

    @Override
    public void onBackPressed() {
        backPressCloseHandler.onBackPressed();
    }

    @Override
    public void onResume() {
        super.onResume();
        EditText idinput = (EditText) findViewById(R.id.idText);
        CheckBox saveid = (CheckBox) findViewById(R.id.saveId);
        String id = PropertyManager.getInstance().getUserId();
        String pw = PropertyManager.getInstance().getPassword();
        if (id != null && !id.equals("")) {
            idinput.setText(id);
            saveid.setChecked(true);
            if (pw != null && !pw.equals("") && MainActivity.logout == false) {
                if (id.equals("123")) {
                    if (pw.equals("123")) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        MainActivity.loginStatus = true;
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); // 메인을 들어가면 메인 전에 실행했던 TASK 를 모두 삭제
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(this, "ID 또는 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        } else {
            saveid.setChecked(false);
        }

    }
}
