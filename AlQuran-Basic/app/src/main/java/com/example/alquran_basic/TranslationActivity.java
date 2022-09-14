package com.example.alquran_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TranslationActivity extends AppCompatActivity {
    ListView translationListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);
        translationListView = findViewById(R.id.translation_list);

        Intent intent = getIntent();
        String ayahText = intent.getStringExtra("ayah");
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();

        ArrayList<TranslationInfo> translationArrayList = databaseAccess.getTranslation(ayahText);
        databaseAccess.close();

        TranslationInfoAdapter translationInfoAdapter = new TranslationInfoAdapter(TranslationActivity.this,translationArrayList);

        translationListView.setAdapter(translationInfoAdapter);
    }
}