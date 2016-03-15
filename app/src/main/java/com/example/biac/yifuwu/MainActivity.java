package com.example.biac.yifuwu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button logInBtn;
    private EditText userName, password;
    private CheckBox remember_pwd, auto_login;
    private String userNameValue, passwordValue;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = this.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        userName = (EditText)findViewById(R.id.Username);
        password = (EditText)findViewById(R.id.Password);
        remember_pwd = (CheckBox)findViewById(R.id.rememberPassword);
        auto_login = (CheckBox)findViewById(R.id.autoLogin);

        if(sp.getBoolean("ISCHECK", false))
        {
            remember_pwd.setChecked(true);
            userName.setText(sp.getString("USER_NAME", ""));
            password.setText(sp.getString("PASSWORD", ""));

            if(sp.getBoolean("AUTO_ISCHECK", false)){

                auto_login.setChecked(true);
                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);
            }
        }

        logInBtn = (Button) findViewById(R.id.LoginButton);
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userNameValue = userName.getText().toString();
                passwordValue = password.getText().toString();

                if (userNameValue.equals("Tom") && passwordValue.equals("123456")) {

                    if (remember_pwd.isChecked()) {
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("USER_NAME", userNameValue);
                        editor.putString("PASSWORD", passwordValue);
                        editor.commit();
                    }

                    Intent intent = new Intent(MainActivity.this, login.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "用户名或密码错误， 请重新登录", Toast.LENGTH_LONG).show();
                }
            }
        });

        remember_pwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (remember_pwd.isChecked()) {
                    sp.edit().putBoolean("ISCHECK", true).commit();
                } else {
                    sp.edit().putBoolean("ISCHECK", false).commit();
                }
            }
        });

        auto_login.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (auto_login.isChecked()) {
                    sp.edit().putBoolean("AUTO_ISCHECK", true).commit();
                } else {
                    sp.edit().putBoolean("AUTO_ISCHECK", false).commit();
                }
            }
        });

    }
}
