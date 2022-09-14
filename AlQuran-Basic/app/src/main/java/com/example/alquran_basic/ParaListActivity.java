package com.example.alquran_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ParaListActivity extends AppCompatActivity {
    ListView paraList;
    DatabaseAccess databaseAccess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_para_list);

        paraList = findViewById(R.id.para_list);

        databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        ArrayList<ParaInfo> paraInfoArrayList = databaseAccess.getParaInfo();
        databaseAccess.close();
        ParaInfoAdapter paraInfoAdapter = new ParaInfoAdapter(ParaListActivity.this,paraInfoArrayList);
        paraList.setAdapter(paraInfoAdapter);

        paraList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ParaInfo paraInfo = (ParaInfo) adapterView.getItemAtPosition(i);
                int paraNum = paraInfo.getParaID();

                Intent intent = new Intent(ParaListActivity.this,AyahListActivity.class);
                intent.putExtra("intentFrom","paraActivity");
                intent.putExtra("ID",String.valueOf(paraNum));

                startActivity(intent);
            }
        });
    }
}