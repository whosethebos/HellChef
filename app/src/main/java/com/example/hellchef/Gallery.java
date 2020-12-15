package com.example.hellchef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hellchef.navigation.SmartcameraFragment;

public class Gallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
    }

    public void back(View view) {
        Intent in = new Intent(Gallery.this,Home.class);
        startActivity(in);
        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new SmartcameraFragment()).commit();
    }

    public void veggi1(View view) {
        Intent in = new Intent(Gallery.this, Veggi1.class);
        startActivity(in);
    }

    public void veggi(View view) {
        Intent in = new Intent(Gallery.this, Veggi.class);
        startActivity(in);
    }
}