package com.example.hellchef;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Additional extends AppCompatActivity {

    final FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mref = mDatabase.getReference();

    ImageView pasta,chilli,tacos,coffee,logout;
    ImageView pasta_liked,chilli_liked,tacos_liked,carrot_liked,coffee_liked;
    int pasta_count,chilli_count,tacos_count,carrot_count,coffee_count;

    public void pastaFunc(View v)
    {
        DatabaseReference messageRef = mref.child("liked");
        ImageView im;
        im = findViewById(R.id.liked_inside);
        pasta_count++;
        if(pasta_count%2!=0)
        {
            messageRef.child("pasta").child("image").setValue("https://firebasestorage.googleapis.com/v0/b/hellchef-28282.appspot.com/o/pasta_short.png?alt=media&token=2506d650-b628-4a85-9881-1aff538f473f");
            pasta_liked.setImageResource(R.drawable.heart_fill);
            im.setImageResource(R.drawable.saved);
            Toast.makeText(getApplicationContext(),"Added to Liked Recipes",Toast.LENGTH_SHORT).show();
        }
        else
        {
            messageRef.child("pasta").removeValue();
            pasta_liked.setImageResource(R.drawable.heart_btn);
            im.setImageResource(R.drawable.saved_recipe);
            Toast.makeText(getApplicationContext(),"Removed from Liked Recipes",Toast.LENGTH_SHORT).show();
        }
    }
}
