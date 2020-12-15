package com.example.hellchef;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Shopping1 extends AppCompatActivity {
    ListView lv;
    ArrayList<String> items;
    ArrayAdapter adapter;
    ImageView add;
    ArrayList<String> list_ing = new ArrayList<>();

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping1);

        lv = (ListView)findViewById(R.id.listview);
        add = (ImageView)findViewById(R.id.add);
        items = new ArrayList<>();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                additemlist(v);
            }
        });

        adapter = new ArrayAdapter<>(this, R.layout.black_text,R.id.list_content,items);
        lv.setAdapter(adapter);
        setUpListViewListener();

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("ingredients").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                items.clear();
                for(DataSnapshot ds: snapshot.getChildren())
                {
                    List x = Collections.singletonList(ds.getKey());
                    for(int i=0;i<x.size();i++)
                    {
                        items.add((String) x.get(i));
                    }
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Shopping1.this, "Failed to retrieve list from database", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setUpListViewListener() {
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long l) {
                Context context = getApplicationContext();
                //String val = items.remove(i);
                //Toast.makeText(context,val,Toast.LENGTH_SHORT).show();
                //Log.d("LONG CLICK",val);
                //mDatabase.child("ingredients").child(val).removeValue();
                Toast.makeText(context,"Item Removed",Toast.LENGTH_LONG).show();
                items.remove(i);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    public void additemlist(View view) {
        //add code for dialog box for adding item
        EditText e = findViewById(R.id.editTextadd);
        String val = e.getText().toString();
        String res;
        HashMap hashMap = new HashMap();

        if(!val.equals("")){
            //items.add(val);
            hashMap.put(val,0);
            mDatabase.child("ingredients").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(getApplicationContext(), "Added to Shopping List", Toast.LENGTH_SHORT).show();

                    adapter.notifyDataSetChanged();
                    //rest
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), "Something went wrong!", Toast.LENGTH_SHORT).show();
                }
            });

            e.setText("");
        }
        else{
            Toast.makeText(getApplicationContext(),"Item field is empty",Toast.LENGTH_LONG).show();

        }
    }
}