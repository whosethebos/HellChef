package com.example.hellchef.navigation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hellchef.Messages;
import com.example.hellchef.R;
import com.example.hellchef.RecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Liked1Fragment extends Fragment {
    RecyclerView recyclerView;
    private DatabaseReference myRef;

    private ArrayList<Messages> messagesList;
    private RecyclerAdapter recyclerAdapter;
    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view =  inflater.inflate(R.layout.activity_liked1,container,false);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        recyclerView = getView().findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
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
                recyclerAdapter = new RecyclerAdapter(getActivity(),messagesList);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(),"Error to retrieve images from firebase",Toast.LENGTH_SHORT).show();
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