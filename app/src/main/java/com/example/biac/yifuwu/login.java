package com.example.biac.yifuwu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;

public class login extends Activity {

    private ProgressBar progressBar;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login);

        progressBar = (ProgressBar)findViewById(R.id.pgBar);
        backButton = (Button)findViewById(R.id.btn_back);

//        try{
//            Thread.sleep(2000);
//        }catch(InterruptedException e){
//            e.printStackTrace();
//        }

        Intent intent = new Intent(login.this, UserHome.class);
        startActivity(intent);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
