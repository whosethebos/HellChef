package com.example.hellchef.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.hellchef.R;
import com.example.hellchef.Shopping1;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class ShoppinglistFragment extends Fragment {
    ImageView additem;
    ChipNavigationBar chipNavigationBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view =  inflater.inflate(R.layout.activity_shoppinglist,container,false);
        additem = view.findViewById(R.id.imageView34);
        additem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent in = new Intent(getActivity(), Shopping1.class);
                //startActivity(in);
                Fragment fragment = new Shopping1Fragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
    /*
    public void additem(View view) {
        Intent in = new Intent(getActivity(), Shopping1.class);
        startActivity(in);
    }*/
}