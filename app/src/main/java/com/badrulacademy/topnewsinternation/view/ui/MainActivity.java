package com.badrulacademy.topnewsinternation.view.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.badrulacademy.topnewsinternation.R;
import com.badrulacademy.topnewsinternation.view.adapter.PagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager2 viewPager;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolBar_id);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tabLayout_id);
        viewPager = findViewById(R.id.viewPager_id);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), getLifecycle());

        viewPager.setAdapter(pagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        if(position == 0){
                            tab.setText("Home");
                        }
                        else if(position == 1){
                            tab.setText("Sports");
                        }
                        else if(position == 2){
                            tab.setText("Health");
                        }
                        else if(position == 3){
                            tab.setText("Science");
                        }
                        else if(position == 4){
                            tab.setText("Entertainment");
                        }
                        else if(position == 5){
                            tab.setText("Technology");
                        }
                        else if(position == 6){
                            tab.setText("Business");
                        }
                    }
                }).attach();

    }
}