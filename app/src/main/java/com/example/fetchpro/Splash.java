package com.example.fetchpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //creating thread for splash to run...
        Thread thread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    sleep(2000);
                }

                catch(Exception e)
                {
                    e.printStackTrace();
                }

                finally
                {
                    //some checks will be required for condition to either be redirected to home or onboarding...
                    Intent intent = new Intent(Splash.this, Login.class);
                    startActivity(intent);
                }
            }
        };
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();

        finish();
    }


}
