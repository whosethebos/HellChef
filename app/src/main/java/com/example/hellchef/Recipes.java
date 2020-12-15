package com.example.hellchef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class Recipes extends AppCompatActivity {
    FirebaseAuth mFirebaseAuth;
    FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
    }

    public void pasta(View view) {
        Intent in = new Intent(this,Pasta.class);
        startActivity(in);
    }

    public void chilli(View view) {
        Intent in = new Intent(this,Chilli.class);
        startActivity(in);
    }

    public void tacos(View view) {
        Intent in = new Intent(this,Tacos.class);
        startActivity(in);
    }

    public void coffee(View view) {
        Intent in = new Intent(this,Coffee.class);
        startActivity(in);
    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        Intent in = new Intent(Recipes.this,MainActivity.class);
        startActivity(in);
    }
}