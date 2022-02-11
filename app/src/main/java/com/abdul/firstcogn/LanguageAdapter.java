package com.abdul.firstcogn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import kotlin.jvm.internal.Lambda;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.LangViewHolder> {
    String[] mLanguages;
    public LanguageAdapter(String[] languages) {
        mLanguages = languages;
    }

    @NonNull
    @Override //ayman - buy the row planks from market
    public LangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_plank,parent,false);
        return new LangViewHolder(rowView);
    }

    @Override //john -- handwriting -- write the data on the planks textview
    public void onBindViewHolder(@NonNull LangViewHolder holder, int position) {
        holder.rowTextview.setText(mLanguages[position]);

    }

    @Override //christine -- keep the count of no items in the data
    public int getItemCount() {
        return mLanguages.length;
    }

    //derek -- maintains the box containing row planks
    class LangViewHolder extends RecyclerView.ViewHolder {
        TextView rowTextview;
        public LangViewHolder(@NonNull View rowViewPlank) {
            super(rowViewPlank);
            rowTextview = rowViewPlank.findViewById(R.id.tvRow);

        }
    }
}
