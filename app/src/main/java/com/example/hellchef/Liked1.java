package com.example.hellchef;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Queue;

public class Liked1 extends AppCompatActivity {
    RecyclerView recyclerView;
    private DatabaseReference myRef;

    private ArrayList<Messages> messagesList;
    private RecyclerAdapter recyclerAdapter;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liked1);

        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        
        myRef = FirebaseDatabase.getInstance().getReference();
        messagesList = new ArrayList<>();

        clearAll();

        getDataFromFirebase();
        //setUpRecycleViewListener();
    }

    private void getDataFromFirebase() {
        Query query = myRef.child("liked");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                clearAll();
                for(DataSnapshot ds:snapshot.getChildren())
                {
                    Messages messages = new Messages();
                    messages.setImageUrl(ds.child("image").getValue().toString());

                    messagesList.add(messages);
                }
                recyclerAdapter = new RecyclerAdapter(getApplicationContext(),messagesList);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //
            }
        });
    }

    private void clearAll()
    {
        if(messagesList!=null)
        {
            messagesList.clear();
            if(recyclerAdapter!=null)
            {
                recyclerAdapter.notifyDataSetChanged();
            }
        }
        messagesList = new ArrayList<>();
    }
}