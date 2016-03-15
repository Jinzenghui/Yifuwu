package com.example.biac.yifuwu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class UserHome extends Activity {

    private Button btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_user_home);

        View btn1 = findViewById(R.id.button1);
        BadgeView badge = new BadgeView(this, btn1);

        badge.setTextSize(12);
        badge.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);
        badge.setText("10");
        badge.show();
    }
}
