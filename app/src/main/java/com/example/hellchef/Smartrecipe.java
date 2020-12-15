package com.example.hellchef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Smartrecipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartrecipe);
    }

    public void back(View view) {
        Intent in = new Intent(Smartrecipe.this,Home.class);
        startActivity(in);
    }

    public void grilled(View view) {
        Intent in = new Intent(Smartrecipe.this,Grilledveggi.class);
        startActivity(in);
    }
}