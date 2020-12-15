package com.example.hellchef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Smartrecipe1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartrecipe1);
    }

    public void back(View view) {
        Intent in = new Intent(Smartrecipe1.this,Home.class);
        startActivity(in);
    }

    public void eggplant(View view) {
        Intent in = new Intent(Smartrecipe1.this,Eggplant.class);
        startActivity(in);
    }

    public void potato(View view) {
        Intent in = new Intent(Smartrecipe1.this,Potato.class);
        startActivity(in);
    }
}