package com.example.hellchef;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Chilli extends AppCompatActivity {
    int counter = 0;
    TextView x1, x2, x3, x4, x5, x6, x7, x8, x9, x10,s;
    int img_count = 0,chilli_count;
    ImageView im;

    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chilli);

        ImageView im = findViewById(R.id.liked_inside);

        myRef = FirebaseDatabase.getInstance().getReference();
        //myRef.child("liked");
        myRef.child("liked").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild("pasta"))
                {
                    im.setImageResource(R.drawable.saved);
                    chilli_count = 1;
                }
                else
                {
                    im.setImageResource(R.drawable.saved_recipe);
                    chilli_count = 0;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Chilli.this,"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void back(View view) {
        Intent in = new Intent(this, Home.class);
        startActivity(in);
    }

    public void shopping(View view) {
        ImageView img = (ImageView) findViewById(R.id.imageView55);
        img.setImageResource(R.drawable.shop_clicked);
        Toast t = Toast.makeText(getApplicationContext(), "Added to Shopping List", Toast.LENGTH_SHORT);
        t.show();
    }

    public void saved(View view) {
        if(chilli_count==1)
        {
            myRef.child("liked").child("chilli").removeValue();
            Toast.makeText(Chilli.this,"Removed from Liked Recipes",Toast.LENGTH_SHORT).show();
        }
        else
        {
            myRef.child("liked").child("chilli").child("image").
                    setValue("https://firebasestorage.googleapis.com/v0/b/hellchef-28282.appspot.com/o/chilli_short.png?alt=media&token=b558e7e3-7aae-4c91-a8ea-e85536808356");
            Toast.makeText(Chilli.this,"Added to Liked Recipes",Toast.LENGTH_SHORT).show();
        }
    }

    public void increment(View view) {
        if(counter<=3) {
            counter++;
            display(counter);
        }

    }

    public void decrement(View view) {
        if(counter>0) {
            counter--;
            display(counter);
        }
    }

    public void display(int counter) {
        switch (counter) {
            case 0:
                s = (TextView) findViewById(R.id.textView62);
                s.setText("Serves 1");
                x1 = (TextView) findViewById(R.id.textView36);
                x1.setText("2/3 cup");
                x2 = (TextView) findViewById(R.id.textView42);
                x2.setText("1 Tbsp");
                x3 = (TextView) findViewById(R.id.textView44);
                x3.setText("3 Tbsp");
                x4 = (TextView) findViewById(R.id.textView46);
                x4.setText("9 oz");
                x5 = (TextView) findViewById(R.id.textView50);
                x5.setText("1 Tbsp");
                x6 = (TextView) findViewById(R.id.textView52);
                x6.setText("1");
                x7 = (TextView) findViewById(R.id.textView54);
                x7.setText("2");
                x8 = (TextView) findViewById(R.id.textView56);
                x8.setText("2 cloves");
                x9 = (TextView) findViewById(R.id.textView58);
                x9.setText("1 1/4 tsp");
                x10 = (TextView) findViewById(R.id.textView60);
                x10.setText("1/2 tsp");
                break;
            case 1:
                s = (TextView) findViewById(R.id.textView62);
                s.setText("Serves 2");
                x1 = (TextView) findViewById(R.id.textView36);
                x1.setText("1 cup");
                x2 = (TextView) findViewById(R.id.textView42);
                x2.setText("1 1/2 Tbsp");
                x3 = (TextView) findViewById(R.id.textView44);
                x3.setText("1/3 cup");
                x4 = (TextView) findViewById(R.id.textView46);
                x4.setText("1.1 lb");
                x5 = (TextView) findViewById(R.id.textView50);
                x5.setText("1 1/2 Tbsp");
                x6 = (TextView) findViewById(R.id.textView52);
                x6.setText("2");
                x7 = (TextView) findViewById(R.id.textView54);
                x7.setText("4");
                x8 = (TextView) findViewById(R.id.textView56);
                x8.setText("4 cloves");
                x9 = (TextView) findViewById(R.id.textView58);
                x9.setText("1 Tbsp");
                x10 = (TextView) findViewById(R.id.textView60);
                x10.setText("1 tsp");
                break;
            case 2:
                s = (TextView) findViewById(R.id.textView62);
                s.setText("Serves 4");
                x1 = (TextView) findViewById(R.id.textView36);
                x1.setText("2 1/3 cups");
                x2 = (TextView) findViewById(R.id.textView42);
                x2.setText("3 Tbsp");
                x3 = (TextView) findViewById(R.id.textView44);
                x3.setText("3/4 cup");
                x4 = (TextView) findViewById(R.id.textView46);
                x4.setText("2.2 lb");
                x5 = (TextView) findViewById(R.id.textView50);
                x5.setText("3 Tbsp");
                x6 = (TextView) findViewById(R.id.textView52);
                x6.setText("4");
                x7 = (TextView) findViewById(R.id.textView54);
                x7.setText("8");
                x8 = (TextView) findViewById(R.id.textView56);
                x8.setText("8 cloves");
                x9 = (TextView) findViewById(R.id.textView58);
                x9.setText("1 1/2 Tbsp");
                x10 = (TextView) findViewById(R.id.textView60);
                x10.setText("1/2 tsp");
                break;
            case 3:
                s = (TextView) findViewById(R.id.textView62);
                s.setText("Serves 6");
                x1 = (TextView) findViewById(R.id.textView36);
                x1.setText("3 1/2 cups");
                x2 = (TextView) findViewById(R.id.textView42);
                x2.setText("1/3 cup");
                x3 = (TextView) findViewById(R.id.textView44);
                x3.setText("1 1/4 cups");
                x4 = (TextView) findViewById(R.id.textView46);
                x4.setText("3.3 lb");
                x5 = (TextView) findViewById(R.id.textView50);
                x5.setText("1/3 cup");
                x6 = (TextView) findViewById(R.id.textView52);
                x6.setText("6");
                x7 = (TextView) findViewById(R.id.textView54);
                x7.setText("12");
                x8 = (TextView) findViewById(R.id.textView56);
                x8.setText("12 cloves");
                x9 = (TextView) findViewById(R.id.textView58);
                x9.setText("2 1/2 Tbsp");
                x10 = (TextView) findViewById(R.id.textView60);
                x10.setText("1 Tbsp");
                break;
        }
    }
}