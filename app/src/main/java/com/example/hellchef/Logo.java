package com.example.hellchef;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class Logo extends AppCompatActivity {
    EditText email,password;
    ImageView btn;
    FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.editTextTextPersonName);
        password = findViewById(R.id.editTextTextPassword);
        btn = findViewById(R.id.imageView6);
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mAuth.getCurrentUser();
                if(mFirebaseUser!=null)
                {
                    Toast.makeText(Logo.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(Logo.this,Home.class);
                    startActivity(in);
                }
                else
                {
                    Toast.makeText(Logo.this,"Please Login",Toast.LENGTH_SHORT).show();
                }
            }
        };
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString();
                String pword = password.getText().toString();
                if(mail.isEmpty())
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
                    mAuth.signInWithEmailAndPassword(mail,pword).addOnCompleteListener(Logo.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Logo.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent in = new Intent(Logo.this,Home.class);
                                startActivity(in);

                            }
                            else {
                                // If sign in fails, display a message to the user.
                                //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(Logo.this, "Login Failed", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });
    }

    public void register(View view) {
        Intent in = new Intent(this,Register.class);
        startActivity(in);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        mAuth.addAuthStateListener(mAuthStateListener);
    }
}