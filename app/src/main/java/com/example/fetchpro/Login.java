package com.example.fetchpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    TextInputLayout layoutEmail, layoutPassword;
    Button Login;
    TextView forgotPassword, gotoSignUp;
    String User_email, User_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //connecting the views...
        layoutEmail = findViewById(R.id.textInputLayoutEmail2);
        layoutPassword = findViewById(R.id.textInputLayoutPassword2);
        Login = findViewById(R.id.login);
        forgotPassword = findViewById(R.id.tvForgotPassword);
        gotoSignUp = findViewById(R.id.goToSignUp);

        //defining variables...
        User_email = layoutEmail.getEditText().getText().toString();
        User_pass = layoutPassword.getEditText().getText().toString();



        //setting onClickListeners...
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //form validation...
                //this is just a place holder validation, need better validation for email and password validating...
                if (!TextUtils.isEmpty(User_email) && !TextUtils.isEmpty(User_pass)){

                    loginUser();

                    layoutEmail.setErrorEnabled(false);
                    layoutPassword.setErrorEnabled(false);
                }else {

                    layoutEmail.setErrorEnabled(true);
                    layoutPassword.setErrorEnabled(true);
                    layoutEmail.setError("Enter Email");
                    layoutPassword.setError("Enter Password");

                }

            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //calling Forgot password activity...
                Intent intent = new Intent(Login.this, ForgotPassword.class);
                startActivity(intent);

            }
        });

        gotoSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //calling SignUp activity...
                startActivity(new Intent(Login.this, SignUp.class));

            }
        });
    }

    private void loginUser() {

    }
}
