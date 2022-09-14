package com.example.alquran_basic;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchSurahActivity extends AppCompatActivity {

    EditText inputText;
    TextView textView;
    Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_surah);

        inputText=findViewById(R.id.edit_text_search_surah);
        search = findViewById(R.id.search_btn);
        textView = findViewById(R.id.error_text);
        
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = inputText.getText().toString().trim();
                String regex = "^\\d+$";
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(input);
                if(input.equals("") || !m.matches() || Integer.parseInt(input) < 1 || Integer.parseInt(input) > 114){
                    textView.setVisibility(View.VISIBLE);
                }
                else{
                    textView.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(SearchSurahActivity.this,AyahListActivity.class);
                    intent.putExtra("intentFrom","surahActivity");
                    intent.putExtra("ID",input);

                    startActivity(intent);
                }
            }
        });
    }
}