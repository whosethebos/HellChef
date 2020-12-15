package com.example.hellchef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class Veggi1 extends AppCompatActivity {
    Timer timer1,timer2;
    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veggi1);

        im = findViewById(R.id.imageView59);
        timer1 = new Timer();
        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                im.setImageResource(R.drawable.veggi1_label);
                //finish();
            }
        },4000);

        timer2 = new Timer();
        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Veggi1.this,Smartrecipe1.class);
                startActivity(intent);
                finish();
            }
        },6000);

    }
}