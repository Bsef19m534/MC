package com.example.alquran_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class AyahListActivity extends AppCompatActivity {

    ListView ayahList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayah_list);
        ayahList = findViewById(R.id.ayah_list);

        Intent intent = getIntent();
        String intentFrom = intent.getStringExtra("intentFrom");

        if(intentFrom.equals("surahActivity")){
            DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
            databaseAccess.open();

            int surahNum = Integer.parseInt(intent.getStringExtra("ID"));

            ArrayList<AyahInfo> ayahInfoArrayList = databaseAccess.getAyahInfoBySurah(surahNum);
            databaseAccess.close();

            AyahInfoAdapter ayahInfoAdapter = new AyahInfoAdapter(AyahListActivity.this,ayahInfoArrayList);
            ayahList.setAdapter(ayahInfoAdapter);
        }else if(intentFrom.equals("paraActivity")){
            DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
            databaseAccess.open();

            int paraNum = Integer.parseInt(intent.getStringExtra("ID"));

            ArrayList<AyahInfo> ayahInfoArrayList = databaseAccess.getAyahInfoByPara(paraNum);
            databaseAccess.close();

            AyahInfoAdapter ayahInfoAdapter = new AyahInfoAdapter(AyahListActivity.this,ayahInfoArrayList);
            ayahList.setAdapter(ayahInfoAdapter);
        }
    }
}