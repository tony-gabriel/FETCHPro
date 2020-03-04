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

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthCredential;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {

    GoogleSignInClient googleSignInClient;
    
    FirebaseUser firebaseUser;

    //FirebaseDatabase mData;

    TextInputLayout layoutEmail, layoutPhone, layoutPassword;
    Button SignUp, googleSignUp;
    TextView gotoLogin;
    String User_email, User_phone, User_pass;

     FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        mAuth= FirebaseAuth.getInstance();

        // Pending google auth will complete later
        //GoogleSignInOptions googleSignInOptions=new GoogleSignInOptions.Builder();

        //connecting the views...

        //setting onClickListeners...


      /*  googleSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

/*        gotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SignUp.this, Login.class));

            }
        });*/
    }


    public void SignUpActivity(View view) {

        layoutEmail = findViewById(R.id.textInputLayoutEmail2);
        layoutPhone = findViewById(R.id.textInputLayoutPhone);
        layoutPassword = findViewById(R.id.textInputLayoutPassword2);
        SignUp = findViewById(R.id.signUp);
        googleSignUp = findViewById(R.id.googleSignIn);
        gotoLogin = findViewById(R.id.tvGotoLogin);

        //defining variables...


        // Please make progress bar Visible

        RegisterUser();


    }

  private void RegisterUser() {

        User_email = layoutEmail.getEditText().getText().toString();
        User_phone = layoutPhone.getEditText().getText().toString();
        User_pass = layoutPassword.getEditText().getText().toString();


        if(User_email.isEmpty()){
             //layoutEmail.setError("please input valid Mail");
            layoutEmail.requestFocus();

        }

        if ((!Patterns.EMAIL_ADDRESS.matcher(User_email).matches())){
            layoutEmail.requestFocus();
            layoutEmail.setError("enter Valid email address");
            return;


        }

        if (User_phone.isEmpty()){
            layoutPhone.setError("please input phone number");
            layoutPhone.requestFocus();
            return;

        }

        if(User_phone.length() !=11){
            layoutPhone.setError("please enter a valid phone number");
            layoutPhone.requestFocus();
            return;

        }

        if(User_pass.isEmpty()){
            layoutPassword.setError("please enter password");
            layoutPassword.requestFocus();
            return;

        }



        if (User_pass.length() < 6){
            layoutPassword.requestFocus();
            layoutPassword.setError("password is too short");
        }
        Toast.makeText(com.example.fetchpro.SignUp.this, User_email, Toast.LENGTH_SHORT).show();

        //set Progress Bar visible here before authentication

       mAuth.createUserWithEmailAndPassword(User_email, User_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {

               if (task.isSuccessful()){

                   User user  = new User (

                           User_email,
                           User_phone

                   );

                    //Add firebase DataBase to write  registered  User mail and number to Firebase

                   FirebaseDatabase.getInstance().getReference("Users").child(Objects.requireNonNull(Objects.requireNonNull(FirebaseAuth.getInstance()
                           .getCurrentUser())).getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                       @Override
                       public void onComplete(Task<Void> task) {

                         // Please set Progress Bar Gone here

                           if (task.isSuccessful()) {

                               Toast.makeText(com.example.fetchpro.SignUp.this, "success", Toast.LENGTH_SHORT).show();

                         //Create a verification Page xml  layout to verify users
                               // goto verification page
                               
                               verifyUsers();


                           } else {

                               Toast.makeText(com.example.fetchpro.SignUp.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                            }





                   //goto email verification page.


               }


           });
       }



    }
});
    }

    private void verifyUsers() {

     FirebaseUser   user = FirebaseAuth.getInstance().getCurrentUser();

     user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
         @Override
         public void onComplete(@NonNull Task<Void> task) {


             if(task.isSuccessful()){
                 Toast.makeText(com.example.fetchpro.SignUp.this,"Email verified successfully", Toast.LENGTH_LONG).show();


             }


         }
     });
    }}


