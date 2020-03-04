package com.example.fetchpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

 FirebaseAuth mAuth;
    TextInputLayout layoutEmail, layoutPassword;
    Button Login;
    TextView forgotPassword, gotoSignUp;
    String User_email, User_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth=FirebaseAuth.getInstance();

        //connecting the views...
        layoutEmail = findViewById(R.id.textInputLayoutEmail2);
        layoutPassword = findViewById(R.id.textInputLayoutPassword2);
        Login = findViewById(R.id.login);
        forgotPassword = findViewById(R.id.tvForgotPassword);
        gotoSignUp = findViewById(R.id.goToSignUp);

        //defining variables...




        //setting onClickListeners...
        /*Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                //form validation...
                //this is just a place holder validation, need better validation for email and password validating...




                loginUser();

            }
        });*/

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

        User_email = layoutEmail.getEditText().getText().toString().trim();
        User_pass = layoutPassword.getEditText().getText().toString().trim();


        if (User_email.isEmpty()) {
            layoutEmail.requestFocus();
            layoutEmail.setError("please enter your mail");
            return;
        }

        if(User_pass.isEmpty()){
            layoutPassword.requestFocus();
            layoutPassword.setError("enter your password");
            return;

        }
        if ((!Patterns.EMAIL_ADDRESS.matcher(User_email).matches())){
            layoutEmail.requestFocus();
            layoutEmail.setError("enter Valid email address");
            return;


        }


        Toast.makeText(com.example.fetchpro.Login.this, "Hello ", Toast.LENGTH_LONG).show();

        mAuth.signInWithEmailAndPassword(User_email,User_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){

                    Toast.makeText(com.example.fetchpro.Login.this, " Login Sucess", Toast.LENGTH_LONG).show();


                }else{
                  Toast.makeText(com.example.fetchpro.Login.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }

                Login.setEnabled(false);

                Toast.makeText(com.example.fetchpro.Login.this, "You are logged in already ", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void LoginClicked(View view) {

        loginUser();
    }
}
