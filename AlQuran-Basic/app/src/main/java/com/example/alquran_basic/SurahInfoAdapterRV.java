package com.example.alquran_basic;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SurahInfoAdapterRV extends RecyclerView.Adapter<SurahInfoAdapterRV.SurahHolder> {
    ArrayList<SurahInfo> surahInfos;

    public SurahInfoAdapterRV(ArrayList<SurahInfo> surahInfos) {
        this.surahInfos = surahInfos;
    }


    @NonNull
    @Override
    public SurahHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.surah_list_item, parent, false);
        return new SurahHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SurahHolder holder, int position) {
        SurahInfo surahInfo = surahInfos.get(position);
        holder.surahNum.setText(String.valueOf(surahInfo.getSurahID()));
        holder.surahNameUr.setText(surahInfo.getSurahNameUr());
        holder.surahNameEng.setText(surahInfo.getSurahNameEng());
        holder.surahNazool.setText(surahInfo.getSurahNazool());

    }

    @Override
    public int getItemCount() {
        return surahInfos.size();
    }

    class SurahHolder extends RecyclerView.ViewHolder{

        TextView surahNum,surahNameUr,surahNameEng,surahNazool;
        public SurahHolder(@NonNull View itemView) {
            super(itemView);
            surahNum = itemView.findViewById(R.id.surah_list_number);
            surahNameUr = itemView.findViewById(R.id.surah_list_nameur);
            surahNameEng = itemView.findViewById(R.id.surah_list_nameeng);
            surahNazool = itemView.findViewById(R.id.surah_list_nazool);
        }
    }
}
