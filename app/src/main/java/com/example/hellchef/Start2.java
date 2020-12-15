package com.example.hellchef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Start2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start2);
    }

    public void start2_next(View view) {
        Intent in = new Intent(this,Start3.class);
        startActivity(in);

    }

    public void start2_back(View view) {
        Intent in = new Intent(this,Start1.class);
        startActivity(in);
    }

    public void start2_skip(View view) {
        Intent in = new Intent(this,Start4.class);
        startActivity(in);
    }
}