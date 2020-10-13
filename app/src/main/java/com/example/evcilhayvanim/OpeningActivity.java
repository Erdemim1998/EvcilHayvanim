package com.example.evcilhayvanim;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class OpeningActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);
        new CountDownTimer(3000,1000){
            //Timer çalışırken yapılacaklar
            @Override
            public void onTick(long millisUntilFinished) {

            }
            //Timer bittiğinde yapılacaklar
            @Override
            public void onFinish() {
                Intent mainActivity=new Intent(OpeningActivity.this,MenuActivity.class);
                startActivity(mainActivity);
                finish();
            }
        }.start();
    }
}