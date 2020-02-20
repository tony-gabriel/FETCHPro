package com.example.fetchpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {

    TextInputLayout layoutEmail, layoutPhone, layoutPassword;
    Button SignUp, googleSignUp;
    TextView gotoLogin;
    String User_email, User_phone, User_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //connecting the views...
        layoutEmail = findViewById(R.id.textInputLayoutEmail2);
        layoutPhone = findViewById(R.id.textInputLayoutPhone);
        layoutPassword = findViewById(R.id.textInputLayoutPassword2);
        SignUp = findViewById(R.id.signUp);
        googleSignUp = findViewById(R.id.googleSignIn);
        gotoLogin = findViewById(R.id.tvGotoLogin);

        //defining variables...
        User_email = layoutEmail.getEditText().getText().toString();
        User_phone = layoutPhone.getEditText().getText().toString();
        User_pass = layoutPassword.getEditText().getText().toString();

        //setting onClickListeners...
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //form validation...
                //this is just a place holder validation, need better validation for email and password validating...
                //email verification will be added when we link up with firebase...
                if (!TextUtils.isEmpty(User_email)
                        && !TextUtils.isEmpty(User_phone)
                        && !TextUtils.isEmpty(User_pass)
                        && !(User_phone.length()<11)){

                    RegisterUser();

                    layoutEmail.setErrorEnabled(false);
                    layoutPhone.setErrorEnabled(false);
                    layoutPassword.setErrorEnabled(false);
                }else{

                    layoutEmail.setErrorEnabled(true);
                    layoutPhone.setErrorEnabled(true);
                    layoutPassword.setErrorEnabled(true);
                    layoutEmail.setError("Enter Email");
                    layoutPhone.setError("Enter Valid Phone Number");
                    layoutPassword.setError("Enter Password");
                }

            }
        });

        googleSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        gotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SignUp.this, Login.class));

            }
        });
    }

    private void RegisterUser() {

    }
}
