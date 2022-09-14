package com.example.alquran_basic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ParaInfoAdapterRV extends RecyclerView.Adapter<ParaInfoAdapterRV.ParaHolder> {

    ArrayList<ParaInfo> paraInfos;

    public ParaInfoAdapterRV(ArrayList<ParaInfo> paraInfos) {
        this.paraInfos = paraInfos;
    }

    @NonNull
    @Override
    public ParaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.para_list_item, parent, false);
        return new ParaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParaHolder holder, int position) {
        ParaInfo paraInfo = paraInfos.get(position);

        holder.paraNum.setText(String.valueOf(paraInfo.getParaID()));
        holder.paraNameUr.setText(paraInfo.getParaNameU());
        holder.paraNameEng.setText(paraInfo.getParaNameE());
    }

    @Override
    public int getItemCount() {
        return paraInfos.size();
    }

    class ParaHolder extends RecyclerView.ViewHolder{

        TextView paraNum,paraNameUr,paraNameEng;
        public ParaHolder(@NonNull View itemView) {
            super(itemView);
            paraNum = itemView.findViewById(R.id.para_list_num);
            paraNameUr = itemView.findViewById(R.id.para_list_nameur);
            paraNameEng = itemView.findViewById(R.id.para_list_nameeng);
        }
    }
}
