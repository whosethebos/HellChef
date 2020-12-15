package com.example.hellchef;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    EditText username,email,password;
    ImageView btn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        username = findViewById(R.id.editTextTextPersonName2);
        email = findViewById(R.id.editTextTextPersonName3);
        password = findViewById(R.id.editTextTextPassword2);
        btn = findViewById(R.id.imageView7);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString();
                String mail = email.getText().toString();
                String pword = password.getText().toString();
                if(uname.isEmpty())
                {
                    username.setError("Please enter Username");
                    username.requestFocus();
                    return;
                }
                else if(mail.isEmpty())
                {
                    email.setError("Please enter Email Address");
                    email.requestFocus();
                    return;
                }
                else if(pword.isEmpty())
                {
                    password.setError("Please enter Password");
                    password.requestFocus();
                    return;
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches())
                {
                    email.setError("Please enter Valid Email Address");
                    email.requestFocus();
                    return;
                    //Toast.makeText(Register.this,"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    mAuth.createUserWithEmailAndPassword(mail, pword)
                            .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Toast.makeText(Register.this,"Registered Successfully",Toast.LENGTH_LONG).show();
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Intent in = new Intent(Register.this,Home.class);
                                        startActivity(in);

                                    }
                                    else {
                                        // If sign in fails, display a message to the user.
                                        //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(Register.this, "Registration Failed.", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                }
            }
        });


    }

    public void login(View view) {
        Intent in = new Intent(this,Logo.class);
        startActivity(in);
    }

}