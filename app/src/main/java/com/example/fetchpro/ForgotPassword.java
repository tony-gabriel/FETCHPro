package com.example.fetchpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    TextInputLayout layoutEmail;
    Button Retrieve;
    String mail;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);



        mAuth= FirebaseAuth.getInstance();

        layoutEmail = findViewById(R.id.textInputLayoutEmail3);
        Retrieve = findViewById(R.id.retrieve);


        //setting onClickListeners...
        Retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mail = layoutEmail.getEditText().getText().toString();
                Toast.makeText(ForgotPassword.this, mail, Toast.LENGTH_LONG).show();

               mAuth.sendPasswordResetEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if(task.isSuccessful()){

                            Toast.makeText(ForgotPassword.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();


                        } else {

                            Toast.makeText(ForgotPassword.this, "password reset failed",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                //...
            }
        });

    }
}
