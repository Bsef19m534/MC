package com.example.alquran_basic;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AyahInfoAdapter extends ArrayAdapter<AyahInfo> {
    Context mContext;
    ArrayList<AyahInfo> ayahArrayList;
    public AyahInfoAdapter(@NonNull Context context, ArrayList<AyahInfo> ayahList) {
        super(context, 0,ayahList);
        mContext = context;
        ayahArrayList = ayahList;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        AyahInfo std = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.ayah_list_item, parent, false);

        TextView ayahNum = convertView.findViewById(R.id.ayah_list_number);
        TextView ayahText = convertView.findViewById(R.id.ayah_list_arabic_txt);
        ImageButton translation = convertView.findViewById(R.id.ayah_list_btn_translate);

        ayahNum.setText(String.valueOf(std.getAyahID()));
        ayahText.setText(std.getAyahText());

        translation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),TranslationActivity.class);
                intent.putExtra("ayah",ayahText.getText());
                mContext.startActivity(intent);
            }
        });

        return convertView;
    }
}
