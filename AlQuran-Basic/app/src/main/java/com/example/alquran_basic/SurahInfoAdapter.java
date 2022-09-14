package com.example.alquran_basic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SurahInfoAdapter extends ArrayAdapter<SurahInfo> {
    Context mContext;
    ArrayList<SurahInfo> surahArrayList;
    public SurahInfoAdapter(@NonNull Context context, ArrayList<SurahInfo> surahList) {
        super(context, 0,surahList);
        mContext = context;
        surahArrayList = surahList;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        SurahInfo std = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.surah_list_item, parent, false);

        TextView surahNum = convertView.findViewById(R.id.surah_list_number);
        TextView surahNameUr = convertView.findViewById(R.id.surah_list_nameur);
        TextView surahNameEng = convertView.findViewById(R.id.surah_list_nameeng);
        TextView surahNazool = convertView.findViewById(R.id.surah_list_nazool);

        surahNum.setText(String.valueOf(std.getSurahID()));
        surahNameUr.setText(std.getSurahNameUr());
        surahNameEng.setText(std.getSurahNameEng());
        surahNazool.setText(std.getSurahNazool());

        return convertView;
    }
}
