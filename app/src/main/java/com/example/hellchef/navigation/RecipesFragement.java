package com.example.hellchef.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.hellchef.Additional;
import com.example.hellchef.Chilli;
import com.example.hellchef.Coffee;
import com.example.hellchef.Home;
import com.example.hellchef.MainActivity;
import com.example.hellchef.Pasta;
import com.example.hellchef.R;
import com.example.hellchef.Recipes;
import com.example.hellchef.Tacos;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RecipesFragement extends Fragment {
    FirebaseAuth mFirebaseAuth;
    FirebaseAuth.AuthStateListener mAuthStateListener;
    final FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mref = mDatabase.getReference();
    private DatabaseReference myRef;

    ImageView pasta,chilli,tacos,coffee,logout;
    ImageView pasta_liked,chilli_liked,tacos_liked,carrot_liked,coffee_liked;
    public int pasta_count,chilli_count,tacos_count,carrot_count,coffee_count;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view =  inflater.inflate(R.layout.activity_recipes,container,false);

        pasta = view.findViewById(R.id.view_pasta);
        chilli = view.findViewById(R.id.view_chilli);
        tacos = view.findViewById(R.id.view_tacos);
        coffee = view.findViewById(R.id.view_coffee);
        logout = view.findViewById(R.id.imageView21);

        pasta_liked = view.findViewById(R.id.heart1);
        chilli_liked = view.findViewById(R.id.heart2);
        tacos_liked = view.findViewById(R.id.heart3);
        carrot_liked = view.findViewById(R.id.heart4);
        coffee_liked = view.findViewById(R.id.heart5);

        myRef = FirebaseDatabase.getInstance().getReference();
        //myRef.child("liked");
        myRef.child("liked").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild("pasta"))
                {
                    pasta_liked.setImageResource(R.drawable.heart_fill);
                    pasta_count = 1;
                }
                else
                {
                    pasta_liked.setImageResource(R.drawable.heart_btn);
                    pasta_count = 0;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(),"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
        myRef.child("liked").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild("chilli"))
                {
                    chilli_liked.setImageResource(R.drawable.heart_fill);
                    chilli_count = 1;
                }
                else
                {
                    chilli_liked.setImageResource(R.drawable.heart_btn);
                    chilli_count = 0;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(),"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
        myRef.child("liked").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild("tacos"))
                {
                    tacos_liked.setImageResource(R.drawable.heart_fill);
                    tacos_count = 1;
                }
                else
                {
                    tacos_liked.setImageResource(R.drawable.heart_btn);
                    tacos_count = 0;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(),"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
        myRef.child("liked").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild("carrot"))
                {
                    carrot_liked.setImageResource(R.drawable.heart_fill);
                    carrot_count = 1;
                }
                else
                {
                    carrot_liked.setImageResource(R.drawable.heart_btn);
                    carrot_count = 0;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(),"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
        myRef.child("liked").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild("coffee"))
                {
                    coffee_liked.setImageResource(R.drawable.heart_fill);
                    coffee_count = 1;
                }
                else
                {
                    coffee_liked.setImageResource(R.drawable.heart_btn);
                    coffee_count = 0;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(),"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });



        pasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Pasta.class);
                startActivity(in);
            }
        });

        chilli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Chilli.class);
                startActivity(in);
            }
        });

        tacos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Tacos.class);
                startActivity(in);
            }
        });

        coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Coffee.class);
                startActivity(in);
            }
        });



        pasta_liked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pastaFunc();
                if(pasta_count==1)
                {
                    myRef.child("liked").child("pasta").removeValue();
                    Toast.makeText(getActivity(),"Removed from Liked Recipes",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    myRef.child("liked").child("pasta").child("image").
                            setValue("https://firebasestorage.googleapis.com/v0/b/hellchef-28282.appspot.com/o/pasta_short.png?alt=media&token=2506d650-b628-4a85-9881-1aff538f473f");
                    Toast.makeText(getActivity(),"Added to Liked Recipes",Toast.LENGTH_SHORT).show();
                }
            }
        });

        chilli_liked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chilli_count==1)
                {
                    myRef.child("liked").child("chilli").removeValue();
                    Toast.makeText(getActivity(),"Removed from Liked Recipes",Toast.LENGTH_SHORT).show();
                }
                else
                {
                   myRef.child("liked").child("chilli").child("image").
                           setValue("https://firebasestorage.googleapis.com/v0/b/hellchef-28282.appspot.com/o/chilli_short.png?alt=media&token=b558e7e3-7aae-4c91-a8ea-e85536808356");
                    Toast.makeText(getActivity(),"Added to Liked Recipes",Toast.LENGTH_SHORT).show();
                }
            }
        });

        tacos_liked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tacos_count==1)
                {
                    myRef.child("liked").child("tacos").removeValue();
                    Toast.makeText(getActivity(),"Removed from Liked Recipes",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    myRef.child("liked").child("tacos").child("image").
                            setValue("https://firebasestorage.googleapis.com/v0/b/hellchef-28282.appspot.com/o/tacos_short.png?alt=media&token=0008a015-67b4-42f5-8c47-09acf7c3babe");
                    Toast.makeText(getActivity(),"Added to Liked Recipes",Toast.LENGTH_SHORT).show();
                }
            }
        });

        carrot_liked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(carrot_count==1)
                {
                    myRef.child("liked").child("carrot").removeValue();
                    Toast.makeText(getActivity(),"Removed from Liked Recipes",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    myRef.child("liked").child("carrot").child("image").
                            setValue("https://firebasestorage.googleapis.com/v0/b/hellchef-28282.appspot.com/o/carrot_short.png?alt=media&token=2bdb5dd6-e114-46af-ab7b-7ed072d17d38");
                    Toast.makeText(getActivity(),"Added to Liked Recipes",Toast.LENGTH_SHORT).show();
                }
            }
        });

        coffee_liked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(coffee_count==1)
                {
                    myRef.child("liked").child("coffee").removeValue();
                    Toast.makeText(getActivity(),"Removed from Liked Recipes",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    myRef.child("liked").child("coffee").child("image").
                            setValue("https://firebasestorage.googleapis.com/v0/b/hellchef-28282.appspot.com/o/coffee_short.png?alt=media&token=528aaad3-8d6f-42a3-8d12-014412cfaf8f");
                    Toast.makeText(getActivity(),"Added to Liked Recipes",Toast.LENGTH_SHORT).show();
                }
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent in = new Intent(getActivity(),MainActivity.class);
                startActivity(in);
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}