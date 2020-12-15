package com.example.hellchef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Start4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start4);
    }

    public void start4_next(View view) {
        Intent in = new Intent(this,Logo.class);
        startActivity(in);
    }

    public void start4_back(View view) {
        Intent in = new Intent(this,Start3.class);
        startActivity(in);

    }
}