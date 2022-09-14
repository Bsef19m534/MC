package com.example.alquran_basic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class ParaListActivityRV extends AppCompatActivity {

    DatabaseAccess databaseAccess;
    RecyclerView paraList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_para_list_rv);
        paraList = findViewById(R.id.para_list_rv);
        paraList.setLayoutManager(new LinearLayoutManager(this));
        databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        ArrayList<ParaInfo> paraInfoArrayList = databaseAccess.getParaInfo();
        databaseAccess.close();
        ParaInfoAdapterRV paraInfoAdapter = new ParaInfoAdapterRV(paraInfoArrayList);
        paraList.setAdapter(paraInfoAdapter);

        paraList.setClickable(true);
    }
}