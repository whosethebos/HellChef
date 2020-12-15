package com.example.hellchef;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.hellchef.navigation.CategoriesFragment;
import com.example.hellchef.navigation.Liked1Fragment;
import com.example.hellchef.navigation.LikedFragment;
import com.example.hellchef.navigation.RecipesFragement;
import com.example.hellchef.navigation.Shopping1Fragment;
import com.example.hellchef.navigation.ShoppinglistFragment;
import com.example.hellchef.navigation.SmartcameraFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.Collections;
import java.util.List;

public class Home extends AppCompatActivity {
    ChipNavigationBar chipNavigationBar;
    String liked_count,ing_count;
    String open_smartcamera="";
    Bundle extra;

    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        extra = getIntent().getExtras();
        //open_smartcamera = extra.getString("gallery");
        /*if(!(extra.getString("gallery") ==null))
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new SmartcameraFragment()).commit();
        }*/

        myRef = FirebaseDatabase.getInstance().getReference();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild("liked"))
                {
                    liked_count = "1";
                    Log.d("liked",liked_count);
                }
                else
                {
                    liked_count = "0";
                    Log.d("lnot",liked_count);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Home.this,"Unable to retrieve data",Toast.LENGTH_SHORT).show();
            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild("ingredients"))
                {
                    ing_count = "1";
                    //Log.d("liked",liked_count);
                }
                else
                {
                    ing_count = "0";
                    //Log.d("lnot",liked_count);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Home.this,"Unable to retrieve data",Toast.LENGTH_SHORT).show();
            }
        });

        chipNavigationBar = findViewById(R.id.bottomNav);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new RecipesFragement()).commit();
        bottomMenu();
    }

    private void bottomMenu() {
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            Fragment fragment=null;
            @Override
            public void onItemSelected(int i) {
                switch (i){
                    case R.id.recipes:
                        fragment = new RecipesFragement();
                        break;
                    case R.id.categories:
                        fragment = new CategoriesFragment();
                        break;
                    case R.id.smartcamera:
                        fragment = new SmartcameraFragment();
                        break;
                    case R.id.liked:
                        if(liked_count.equals("1"))
                            fragment = new Liked1Fragment();
                        else
                            fragment = new LikedFragment();
                        break;
                    case R.id.shopping:
                        if(ing_count.equals("1"))
                            fragment = new Shopping1Fragment();
                        else
                            fragment = new ShoppinglistFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            }
        });
    }
}