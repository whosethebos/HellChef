package com.example.hellchef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Start3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start3);
    }

    public void start3_next(View view) {
        Intent in = new Intent(this,Start4.class);
        startActivity(in);

    }

    public void start3_skip(View view) {
        Intent in = new Intent(this,Start4.class);
        startActivity(in);

    }

    public void start3_back(View view) {
        Intent in = new Intent(this,Start2.class);
        startActivity(in);

    }
}