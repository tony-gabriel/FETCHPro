package com.example.fetchpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class ForgotPassword extends AppCompatActivity {

    TextInputLayout layoutEmail;
    Button Retrieve;
    String Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        layoutEmail = findViewById(R.id.textInputLayoutEmail3);
        Retrieve = findViewById(R.id.retrieve);

        Email = layoutEmail.getEditText().getText().toString();

        //setting onClickListeners...
        Retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //...
            }
        });

    }
}
