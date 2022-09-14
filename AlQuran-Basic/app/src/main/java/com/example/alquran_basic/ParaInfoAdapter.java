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

public class ParaInfoAdapter extends ArrayAdapter<ParaInfo> {
    Context mContext;
    ArrayList<ParaInfo> paraArrayList;
    public ParaInfoAdapter(@NonNull Context context, ArrayList<ParaInfo> paraList) {
        super(context, 0,paraList);
        mContext = context;
        paraArrayList = paraList;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ParaInfo std = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.para_list_item, parent, false);

        TextView surahNum = convertView.findViewById(R.id.para_list_num);
        TextView surahNameUr = convertView.findViewById(R.id.para_list_nameur);
        TextView surahNameEng = convertView.findViewById(R.id.para_list_nameeng);

        surahNum.setText(String.valueOf(std.getParaID()));
        surahNameUr.setText(std.getParaNameU());
        surahNameEng.setText(std.getParaNameE());

        return convertView;
    }
}
