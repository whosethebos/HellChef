package com.example.hellchef.navigation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.example.hellchef.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Shopping1Fragment extends Fragment {
    ListView lv;
    EditText edit;
    ArrayList<String> items;
    ArrayAdapter<String> adapter;
    ImageView add;
    ArrayList<String> list_ing = new ArrayList<>();

    private DatabaseReference mDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity_shopping1,container,false);
        lv = view.findViewById(R.id.listview);
        add = view.findViewById(R.id.add);
        edit = view.findViewById(R.id.editTextadd);
        items = new ArrayList<>();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //add code for dialog box for adding item
                String val = edit.getText().toString();
                String res;
                HashMap<String, Object> hashMap = new HashMap<String,Object>();

                if(!val.equals("")){
                    //items.add(val);
                    hashMap.put(val,0);
                    mDatabase.child("ingredients").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getActivity(), "Added to Shopping List", Toast.LENGTH_SHORT).show();

                            adapter.notifyDataSetChanged();
                            //rest
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getActivity(), "Something went wrong!", Toast.LENGTH_SHORT).show();
                        }
                    });

                    edit.setText("");
                }
                else{
                    Toast.makeText(getActivity(),"Item field is empty",Toast.LENGTH_LONG).show();

                }
            }
        });

        adapter = new ArrayAdapter<>(getActivity(), R.layout.black_text,R.id.list_content,items);
        lv.setAdapter(adapter);
        setUpListViewListener();

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("ingredients").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                items.clear();
                for(DataSnapshot ds: snapshot.getChildren())
                {
                    List<String> x = Collections.singletonList(ds.getKey());
                    for(int i=0;i<x.size();i++)
                    {
                        items.add((String) x.get(i));
                    }
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), "Failed to retrieve list from database", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void setUpListViewListener() {
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long l) {
                Context context = getActivity();
                String val = items.get(i);
                //Toast.makeText(context,val,Toast.LENGTH_LONG).show();
                mDatabase.child("ingredients").child(val).removeValue();
                Toast.makeText(context,"Item Removed",Toast.LENGTH_LONG).show();
                items.remove(i);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}