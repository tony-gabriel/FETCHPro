package com.example.fetchpro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    Button Btn_next, getStarted;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn_next = findViewById(R.id.btn_next);


        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Fresh Food", "", R.drawable.fast_food));
        mList.add(new ScreenItem("Fast and Easy Delivery", "", R.drawable.bike));
        mList.add(new ScreenItem("Secure and Easy Payment", "", R.drawable.secure_payment));


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


                    loadLastScreen();

                }


            }
        });

    }

    private void loadLastScreen() {


    }
}
