package com.example.hellchef;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class Grilledveggi extends AppCompatActivity {
    private ImageView im,step_by,btn;
    private TextView text;
    int counter = 0;
    int img_count = 0,grilled_count;
    TextView x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, s;
    CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18;
    TextView v;
    String val;
    ScrollView scrollView;
    ArrayList<String> value = new ArrayList<>();

    //FirebaseDatabase database = FirebaseDatabase.getInstance();
    //DatabaseReference myRef = database.getReference("ingredients");
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grilledveggi);

        step_by = findViewById(R.id.imageView56);
        text = findViewById(R.id.textView63);
        scrollView = findViewById(R.id.scroll);
        btn = findViewById(R.id.imageView73);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                step_by.requestFocus();
                focusOnView();
            }
        });

        mDatabase = FirebaseDatabase.getInstance().getReference();

        ImageView im = findViewById(R.id.imageView72);
        mDatabase.child("liked").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild("grilledveggi"))
                {
                    im.setImageResource(R.drawable.saved);
                    grilled_count = 1;
                }
                else
                {
                    im.setImageResource(R.drawable.saved_recipe);
                    grilled_count = 0;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Grilledveggi.this,"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private final void focusOnView() {
        new Handler().post(new Runnable() {
            //scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.smoothScrollTo(0,text.getBottom());
            }
        });
    }

    public void saved(View view) {
        if(grilled_count==1)
        {
            mDatabase.child("liked").child("grilledveggi").removeValue();
            Toast.makeText(Grilledveggi.this,"Removed from Liked Recipes",Toast.LENGTH_SHORT).show();
        }
        else
        {
            mDatabase.child("liked").child("grilledveggi").child("image").
                    setValue("https://firebasestorage.googleapis.com/v0/b/hellchef-28282.appspot.com/o/sr1.png?alt=media&token=4bef9cb3-afba-43f6-ace7-1f1011a6dc64");
            Toast.makeText(Grilledveggi.this,"Added to Liked Recipes",Toast.LENGTH_SHORT).show();
        }
    }

    public void back(View view) {
        Intent in = new Intent(this, Smartrecipe.class);
        startActivity(in);
    }

    public void shopping(View view) {
        ImageView img = (ImageView) findViewById(R.id.imageView55);
        //img.setImageResource(R.drawable.shop_clicked);
        //Shopping1 sp = new Shopping1();


        c1 = findViewById(R.id.checkBox102);
        c2 = findViewById(R.id.checkBox105);
        c3 = findViewById(R.id.checkBox108);
        c4 = findViewById(R.id.checkBox111);
        c5 = findViewById(R.id.checkBox114);
        c6 = findViewById(R.id.checkBox117);
        c7 = findViewById(R.id.checkBox120);
        c8 = findViewById(R.id.checkBox123);
        c9 = findViewById(R.id.checkBox126);
        c10 = findViewById(R.id.checkBox129);
        c11 = findViewById(R.id.checkBox132);
        c12 = findViewById(R.id.checkBox135);
        c13 = findViewById(R.id.checkBox138);

        if(c1.isChecked())
        {
            v = findViewById(R.id.textView101);
            val = v.getText().toString();
            value.add(val);
        }
        if(c2.isChecked())
        {
            v = findViewById(R.id.textView104);
            val = v.getText().toString();
            value.add(val);
        }
        if(c3.isChecked())
        {
            v = findViewById(R.id.textView107);
            val = v.getText().toString();
            value.add(val);
        }
        if(c4.isChecked())
        {
            v = findViewById(R.id.textView110);
            val = v.getText().toString();
            value.add(val);
        }
        if(c5.isChecked())
        {
            v = findViewById(R.id.textView113);
            val = v.getText().toString();
            value.add(val);
        }
        if(c6.isChecked())
        {
            v = findViewById(R.id.textView116);
            val = v.getText().toString();
            value.add(val);
        }
        if(c7.isChecked())
        {
            v = findViewById(R.id.textView119);
            val = v.getText().toString();
            value.add(val);
        }
        if(c8.isChecked())
        {
            v = findViewById(R.id.textView122);
            val = v.getText().toString();
            value.add(val);
        }
        if(c9.isChecked())
        {
            v = findViewById(R.id.textView125);
            val = v.getText().toString();
            value.add(val);
        }
        if(c10.isChecked())
        {
            v = findViewById(R.id.textView128);
            val = v.getText().toString();
            value.add(val);
        }
        if(c11.isChecked())
        {
            v = findViewById(R.id.textView131);
            val = v.getText().toString();
            value.add(val);
        }
        if(c12.isChecked())
        {
            v = findViewById(R.id.textView134);
            val = v.getText().toString();
            value.add(val);
        }
        if(c13.isChecked())
        {
            v = findViewById(R.id.textView137);
            val = v.getText().toString();
            value.add(val);
        }

        HashMap hashMap = new HashMap();
        for(int i=0;i<value.size();i++) {
            //String index = String.valueOf(i);
            String index = String.valueOf(0);
            String val = value.get(i);
            hashMap.put(val,index);
            //Ingredients in = new Ingredients(val,index);
            //mDatabase.child("ingredients").setValue(in);
            //myRef.setValue(a);
            //Log.d("list",a);
        }

        mDatabase.child("ingredients").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                img.setImageResource(R.drawable.shop_clicked);
                Toast.makeText(getApplicationContext(), "Added to Shopping List", Toast.LENGTH_SHORT).show();
                //rest
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        });

        //Intent in = new Intent(Eggplant.this,Shopping1.class);
        //startActivity(in);


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
        switch (counter)
        {
            case 0:
                s = (TextView) findViewById(R.id.textView62);
                s.setText("Serves 1");
                x1 = (TextView) findViewById(R.id.textView36);
                x1.setText("1 Tbsp");
                x2 = (TextView) findViewById(R.id.textView42);
                x2.setText("1/4 sprig");
                x3 = (TextView) findViewById(R.id.textView44);
                x3.setText("3/4 tsp");
                x4 = (TextView) findViewById(R.id.textView46);
                x4.setText("1/2 Tbsp");
                x5 = (TextView) findViewById(R.id.textView50);
                x5.setText("1/8");
                x6 = (TextView) findViewById(R.id.textView52);
                x6.setText("1/8 tsp");
                x7 = (TextView) findViewById(R.id.textView54);
                x7.setText("1/8 tsp");
                x8 = (TextView) findViewById(R.id.textView56);
                x8.setText("1/2 clove");
                x9 = (TextView) findViewById(R.id.textView58);
                x9.setText("1/4");
                x10 = (TextView) findViewById(R.id.textView60);
                x10.setText("2");
                x11 = (TextView) findViewById(R.id.textView36);
                x11.setText("1/4");
                x12 = (TextView) findViewById(R.id.textView42);
                x12.setText("1/4");
                x13 = (TextView) findViewById(R.id.textView44);
                x13.setText("1");
                break;
            case 2:
                s = (TextView) findViewById(R.id.textView62);
                s.setText("Serves 2");
                x1 = (TextView) findViewById(R.id.textView36);
                x1.setText("2 1/2 Tbsp");
                x2 = (TextView) findViewById(R.id.textView42);
                x2.setText("1/2 sprig");
                x3 = (TextView) findViewById(R.id.textView44);
                x3.setText("1/2 tsp");
                x4 = (TextView) findViewById(R.id.textView46);
                x4.setText("1 Tbsp");
                x5 = (TextView) findViewById(R.id.textView50);
                x5.setText("1/4");
                x6 = (TextView) findViewById(R.id.textView52);
                x6.setText("1/4 tsp");
                x7 = (TextView) findViewById(R.id.textView54);
                x7.setText("1/4 tsp");
                x8 = (TextView) findViewById(R.id.textView56);
                x8.setText("1 clove");
                x9 = (TextView) findViewById(R.id.textView58);
                x9.setText("1/2");
                x10 = (TextView) findViewById(R.id.textView60);
                x10.setText("4");
                x11 = (TextView) findViewById(R.id.textView36);
                x11.setText("1/2");
                x12 = (TextView) findViewById(R.id.textView42);
                x12.setText("1/2");
                x13 = (TextView) findViewById(R.id.textView44);
                x13.setText("2");
                break;
            case 3:
                s = (TextView) findViewById(R.id.textView62);
                s.setText("Serves 4");
                x1 = (TextView) findViewById(R.id.textView36);
                x1.setText("1/3 cup");
                x2 = (TextView) findViewById(R.id.textView42);
                x2.setText("1 sprig");
                x3 = (TextView) findViewById(R.id.textView44);
                x3.setText("1 tsp");
                x4 = (TextView) findViewById(R.id.textView46);
                x4.setText("2 Tbsp");
                x5 = (TextView) findViewById(R.id.textView50);
                x5.setText("1/2");
                x6 = (TextView) findViewById(R.id.textView52);
                x6.setText("1/2 tsp");
                x7 = (TextView) findViewById(R.id.textView54);
                x7.setText("1/2 tsp");
                x8 = (TextView) findViewById(R.id.textView56);
                x8.setText("2 clove");
                x9 = (TextView) findViewById(R.id.textView58);
                x9.setText("1");
                x10 = (TextView) findViewById(R.id.textView60);
                x10.setText("8");
                x11 = (TextView) findViewById(R.id.textView36);
                x11.setText("1");
                x12 = (TextView) findViewById(R.id.textView42);
                x12.setText("1");
                x13 = (TextView) findViewById(R.id.textView44);
                x13.setText("4");
                break;
            case 4:
                s = (TextView) findViewById(R.id.textView62);
                s.setText("Serves 6");
                x1 = (TextView) findViewById(R.id.textView36);
                x1.setText("1/2 cup");
                x2 = (TextView) findViewById(R.id.textView42);
                x2.setText("1 1/2 sprigs");
                x3 = (TextView) findViewById(R.id.textView44);
                x3.setText("1 1/2 Tbsp");
                x4 = (TextView) findViewById(R.id.textView46);
                x4.setText("3 Tbsp");
                x5 = (TextView) findViewById(R.id.textView50);
                x5.setText("3/4");
                x6 = (TextView) findViewById(R.id.textView52);
                x6.setText("3/4 tsp");
                x7 = (TextView) findViewById(R.id.textView54);
                x7.setText("3/4 tsp");
                x8 = (TextView) findViewById(R.id.textView56);
                x8.setText("3 cloves");
                x9 = (TextView) findViewById(R.id.textView58);
                x9.setText("1 1/2");
                x10 = (TextView) findViewById(R.id.textView60);
                x10.setText("12");
                x11 = (TextView) findViewById(R.id.textView36);
                x11.setText("1 1/2");
                x12 = (TextView) findViewById(R.id.textView42);
                x12.setText("1 1/2");
                x13 = (TextView) findViewById(R.id.textView44);
                x13.setText("6");
                break;
        }

    }
}