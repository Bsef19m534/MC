package com.example.alquran_basic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class SurahListActivityRV extends AppCompatActivity {
    DatabaseAccess databaseAccess;
    RecyclerView surahRV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_list_rv);
        surahRV = findViewById(R.id.surah_list_rv);

        surahRV.setLayoutManager(new LinearLayoutManager(this));
        databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        ArrayList<SurahInfo> surahInfoArrayList = databaseAccess.getSurahInfo();
        databaseAccess.close();
        SurahInfoAdapterRV surahInfoAdapterRV = new SurahInfoAdapterRV(surahInfoArrayList);
        surahRV.setAdapter(surahInfoAdapterRV);
    }
}