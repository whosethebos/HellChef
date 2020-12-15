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

public class Pasta extends AppCompatActivity {
    int counter = 0;
    TextView x1, x2, x3, x4, x5, x6, x7, x8, x9, x10,s;
    int img_count = 0,pasta_count;
    ImageView im;

    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasta);

        ImageView im = findViewById(R.id.liked_inside);

        myRef = FirebaseDatabase.getInstance().getReference();
        //myRef.child("liked");
        myRef.child("liked").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild("pasta"))
                {
                    im.setImageResource(R.drawable.saved);
                    pasta_count = 1;
                }
                else
                {
                    im.setImageResource(R.drawable.saved_recipe);
                    pasta_count = 0;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Pasta.this,"Something went wrong",Toast.LENGTH_SHORT).show();
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
        if(pasta_count==1)
        {
            myRef.child("liked").child("pasta").removeValue();
            Toast.makeText(Pasta.this,"Removed from Liked Recipes",Toast.LENGTH_SHORT).show();
        }
        else
        {
            myRef.child("liked").child("pasta").child("image").setValue("https://firebasestorage.googleapis.com/v0/b/hellchef-28282.appspot.com/o/pasta_short.png?alt=media&token=2506d650-b628-4a85-9881-1aff538f473f");
            Toast.makeText(Pasta.this,"Added to Liked Recipes",Toast.LENGTH_SHORT).show();
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
                x1.setText("1/4");
                x2 = (TextView) findViewById(R.id.textView42);
                x2.setText("1 Tbsp");
                x3 = (TextView) findViewById(R.id.textView44);
                x3.setText("2 Tbsp");
                x4 = (TextView) findViewById(R.id.textView46);
                x4.setText("1 1/2");
                x5 = (TextView) findViewById(R.id.textView50);
                x5.setText("3/4 tsp");
                x6 = (TextView) findViewById(R.id.textView52);
                x6.setText("3/4 cup");
                x7 = (TextView) findViewById(R.id.textView54);
                x7.setText("1/2 Tbsp");
                x8 = (TextView) findViewById(R.id.textView56);
                x8.setText("5 oz");
                x9 = (TextView) findViewById(R.id.textView58);
                x9.setText("to taste");
                x10 = (TextView) findViewById(R.id.textView60);
                x10.setText("1/2 Tbsp");
                break;
            case 1:
                s = (TextView) findViewById(R.id.textView62);
                s.setText("Serves 2");
                x1 = (TextView) findViewById(R.id.textView36);
                x1.setText("1/2");
                x2 = (TextView) findViewById(R.id.textView42);
                x2.setText("2 Tbsp");
                x3 = (TextView) findViewById(R.id.textView44);
                x3.setText("1/4 cup");
                x4 = (TextView) findViewById(R.id.textView46);
                x4.setText("3");
                x5 = (TextView) findViewById(R.id.textView50);
                x5.setText("1/2 Tbsp");
                x6 = (TextView) findViewById(R.id.textView52);
                x6.setText("1/2 Tbsp");
                x7 = (TextView) findViewById(R.id.textView54);
                x7.setText("1 Tbsp");
                x8 = (TextView) findViewById(R.id.textView56);
                x8.setText("8 oz");
                x9 = (TextView) findViewById(R.id.textView58);
                x9.setText("to taste");
                x10 = (TextView) findViewById(R.id.textView60);
                x10.setText("1 Tbsp");
                break;
            case 2:
                s = (TextView) findViewById(R.id.textView62);
                s.setText("Serves 4");
                x1 = (TextView) findViewById(R.id.textView36);
                x1.setText("1");
                x2 = (TextView) findViewById(R.id.textView42);
                x2.setText("1/4 cup");
                x3 = (TextView) findViewById(R.id.textView44);
                x3.setText("1/2 cup");
                x4 = (TextView) findViewById(R.id.textView46);
                x4.setText("6");
                x5 = (TextView) findViewById(R.id.textView50);
                x5.setText("1 Tbsp");
                x6 = (TextView) findViewById(R.id.textView52);
                x6.setText("3 1/3 cups");
                x7 = (TextView) findViewById(R.id.textView54);
                x7.setText("2 Tbsp");
                x8 = (TextView) findViewById(R.id.textView56);
                x8.setText("1 lb");
                x9 = (TextView) findViewById(R.id.textView58);
                x9.setText("to taste");
                x10 = (TextView) findViewById(R.id.textView60);
                x10.setText("2 Tbsp");
                break;
            case 3:
                s = (TextView) findViewById(R.id.textView62);
                s.setText("Serves 6");
                x1 = (TextView) findViewById(R.id.textView36);
                x1.setText("1 1/2");
                x2 = (TextView) findViewById(R.id.textView42);
                x2.setText("1/3 cup");
                x3 = (TextView) findViewById(R.id.textView44);
                x3.setText("3/4 cup");
                x4 = (TextView) findViewById(R.id.textView46);
                x4.setText("9");
                x5 = (TextView) findViewById(R.id.textView50);
                x5.setText("1 1/2 Tbsp");
                x6 = (TextView) findViewById(R.id.textView52);
                x6.setText("5 cups");
                x7 = (TextView) findViewById(R.id.textView54);
                x7.setText("3 Tbsp");
                x8 = (TextView) findViewById(R.id.textView56);
                x8.setText("1.5 lb");
                x9 = (TextView) findViewById(R.id.textView58);
                x9.setText("to taste");
                x10 = (TextView) findViewById(R.id.textView60);
                x10.setText("3 Tbsp");
                break;
        }
    }
}

