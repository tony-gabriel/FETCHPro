package com.example.fetchpro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    Button Btn_next;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (restoredPrefData()){

            startActivity(new Intent(MainActivity.this, Login.class));

        }

        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Btn_next = findViewById(R.id.btn_next);


        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Fresh Food", "Tempor aliquip ea culpa magna ullamco esse mollit ex fugiat elit.", R.drawable.fast_food));
        mList.add(new ScreenItem("Fast and Easy Delivery", "Tempor aliquip ea culpa magna ullamco esse mollit ex fugiat elit.", R.drawable.bike));
        mList.add(new ScreenItem("Secure and Easy Payment", "Tempor aliquip ea culpa magna ullamco esse mollit ex fugiat elit.", R.drawable.secure_payment));


        screenPager = findViewById(R.id.screen_viewPager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this,mList);
        screenPager.setAdapter(introViewPagerAdapter);


        Btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                position = screenPager.getCurrentItem();

                if (position < mList.size()){

                    position++;
                    screenPager.setCurrentItem(position);
                }

                if (position == mList.size()){

                    savePrefData();
                    loadLastScreen();
                    finish();

                }


            }
        });

    }

    private boolean restoredPrefData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        Boolean isIntroViewedBefore = pref.getBoolean("isIntroViewed", false);
        return isIntroViewedBefore;

    }

    private void savePrefData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroViewed", true);
        editor.apply();

    }

    private void loadLastScreen() {

        startActivity(new Intent(getApplicationContext(), Welcome.class));
        finish();

    }
}
