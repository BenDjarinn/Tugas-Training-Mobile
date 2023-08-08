package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.ClipData;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Home_activity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;


    RecomendationFragment recomendationFragment = new RecomendationFragment();
    FavortesFragment favortesFragment = new FavortesFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,recomendationFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int itemId = item.getItemId();

                if(itemId == R.id.recommendation) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,recomendationFragment).commit();
                    return true;
                } else if(itemId == R.id.favorites) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,favortesFragment).commit();
                    return true;
                }

                return false;
            }
        });

    }
}