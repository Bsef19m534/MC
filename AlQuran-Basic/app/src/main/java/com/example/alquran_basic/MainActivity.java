package com.example.alquran_basic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    Button mainSurah, mainPara;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainSurah = findViewById(R.id.btn_surah_main);
        mainPara = findViewById(R.id.btn_para_main);

        mainPara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ParaListActivity.class);
                startActivity(intent);
            }
        });

        mainSurah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SurahListActivity.class);
                startActivity(intent);
            }
        });

        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer);

        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_surah:
                        Intent intent = new Intent(MainActivity.this, SurahListActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_para:
                        Intent intent1 = new Intent(MainActivity.this, ParaListActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_search:
                        Intent intent2 = new Intent(MainActivity.this,SearchSurahActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_home:
                        Intent intent3 = new Intent(MainActivity.this,Home.class);
                        startActivity(intent3);
                        break;
                }
                return true;
            }
        });
    }
}