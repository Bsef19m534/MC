package com.example.alquran_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SurahListActivity extends AppCompatActivity {
    ListView surahList;
    DatabaseAccess databaseAccess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_list);

        surahList = findViewById(R.id.surah_list);

        databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        ArrayList<SurahInfo> surahInfoArrayList = databaseAccess.getSurahInfo();
        databaseAccess.close();
        SurahInfoAdapter surahInfoAdapter = new SurahInfoAdapter(SurahListActivity.this,surahInfoArrayList);
        surahList.setAdapter(surahInfoAdapter);

        surahList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SurahInfo surahInfo = (SurahInfo) adapterView.getItemAtPosition(i);
                int surahNum = surahInfo.getSurahID();

                Intent intent = new Intent(SurahListActivity.this,AyahListActivity.class);
                intent.putExtra("intentFrom","surahActivity");
                intent.putExtra("ID",String.valueOf(surahNum));

                startActivity(intent);
            }
        });
    }
}