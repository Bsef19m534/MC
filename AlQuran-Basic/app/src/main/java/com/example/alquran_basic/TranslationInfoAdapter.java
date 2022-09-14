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

public class TranslationInfoAdapter extends ArrayAdapter<TranslationInfo> {
    Context mContext;
    ArrayList<TranslationInfo> translationArrayList;
    public TranslationInfoAdapter(@NonNull Context context, ArrayList<TranslationInfo> translationList) {
        super(context, 0,translationList);
        mContext = context;
        translationArrayList = translationList;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TranslationInfo std = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.translation_list_item, parent, false);

        TextView translator = convertView.findViewById(R.id.translation_by);
        TextView translation = convertView.findViewById(R.id.translation);

        translator.setText(std.getTranslator());
        translation.setText(std.getTranslation());

        return convertView;
    }
}
