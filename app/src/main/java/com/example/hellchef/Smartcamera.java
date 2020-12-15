package com.example.hellchef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Smartcamera extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartcamera);
    }

    public void scan(View view) {
    }

    public void gallery(View view) {
        Intent in = new Intent(this,Gallery.class);
        startActivity(in);
    }
}