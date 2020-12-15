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

public class Coffee extends AppCompatActivity {

    int counter = 0;
    TextView x1, x2, x3, x4, x5, x6, x7, x8, x9, x10,s;
    int img_count = 0,coffee_count;
    ImageView im;

    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tacos);

        myRef = FirebaseDatabase.getInstance().getReference();
        //myRef.child("liked");
        myRef.child("liked").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild("coffee"))
                {
                    im.setImageResource(R.drawable.saved);
                    coffee_count = 1;
                }
                else
                {
                    im.setImageResource(R.drawable.saved_recipe);
                    coffee_count = 0;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Coffee.this,"Something went wrong",Toast.LENGTH_SHORT).show();
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
        if(coffee_count==1)
        {
            myRef.child("liked").child("coffee").removeValue();
            Toast.makeText(Coffee.this,"Removed from Liked Recipes",Toast.LENGTH_SHORT).show();
        }
        else
        {
            myRef.child("liked").child("coffee").child("image").
                    setValue("https://firebasestorage.googleapis.com/v0/b/hellchef-28282.appspot.com/o/coffee_short.png?alt=media&token=528aaad3-8d6f-42a3-8d12-014412cfaf8f");
            Toast.makeText(Coffee.this,"Added to Liked Recipes",Toast.LENGTH_SHORT).show();
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
                x1.setText("1 Tbsp");
                x2 = (TextView) findViewById(R.id.textView42);
                x2.setText("1 Tbsp");
                x3 = (TextView) findViewById(R.id.textView44);
                x3.setText("1 Tbsp");
                x4 = (TextView) findViewById(R.id.textView46);
                x4.setText("1 cup");
                x5 = (TextView) findViewById(R.id.textView50);
                x5.setText("to taste");
                break;
            case 1:
                s = (TextView) findViewById(R.id.textView62);
                s.setText("Serves 2");
                x1 = (TextView) findViewById(R.id.textView36);
                x1.setText("2 Tbsp");
                x2 = (TextView) findViewById(R.id.textView42);
                x2.setText("2 Tbsp");
                x3 = (TextView) findViewById(R.id.textView44);
                x3.setText("2 Tbsp");
                x4 = (TextView) findViewById(R.id.textView46);
                x4.setText("2 cup");
                x5 = (TextView) findViewById(R.id.textView50);
                x5.setText("to taste");
                break;
            case 2:
                s = (TextView) findViewById(R.id.textView62);
                s.setText("Serves 4");
                x1 = (TextView) findViewById(R.id.textView36);
                x1.setText("1/4 cup");
                x2 = (TextView) findViewById(R.id.textView42);
                x2.setText("1/4 cup");
                x3 = (TextView) findViewById(R.id.textView44);
                x3.setText("1/4 cup");
                x4 = (TextView) findViewById(R.id.textView46);
                x4.setText("4 cup");
                x5 = (TextView) findViewById(R.id.textView50);
                x5.setText("to taste");
                break;
            case 3:
                s = (TextView) findViewById(R.id.textView62);
                s.setText("Serves 6");
                x1 = (TextView) findViewById(R.id.textView36);
                x1.setText("1/3 cup");
                x2 = (TextView) findViewById(R.id.textView42);
                x2.setText("1/3 cup");
                x3 = (TextView) findViewById(R.id.textView44);
                x3.setText("1/3 cup");
                x4 = (TextView) findViewById(R.id.textView46);
                x4.setText("6 cup");
                x5 = (TextView) findViewById(R.id.textView50);
                x5.setText("to taste");
                break;
        }
    }
}