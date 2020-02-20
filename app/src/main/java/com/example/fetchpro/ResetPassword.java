package com.example.fetchpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class ResetPassword extends AppCompatActivity {

    TextInputLayout layoutNewPassword, layoutNewPassword2;
    Button Reset;
    String newPassword, newPassword2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        layoutNewPassword = findViewById(R.id.textInputLayoutNp);
        layoutNewPassword2 = findViewById(R.id.textInputLayoutRNP);
        Reset = findViewById(R.id.resetPassword);

        newPassword = layoutNewPassword.getEditText().getText().toString();
        newPassword2 = layoutNewPassword2.getEditText().getText().toString();


        //setting onClickListeners...
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //...
            }
        });
    }
}
