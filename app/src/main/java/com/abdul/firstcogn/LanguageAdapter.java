package com.abdul.firstcogn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import kotlin.jvm.internal.Lambda;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.LangViewHolder> {

    @NonNull
    @Override //ayman - buy the row planks from market
    public LangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_plank,parent,false);
        return new LangViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(@NonNull LangViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class LangViewHolder extends RecyclerView.ViewHolder {
        TextView rowTextview;
        public LangViewHolder(@NonNull View rowViewPlank) {
            super(rowViewPlank);
            rowTextview = rowViewPlank.findViewById(R.id.tvRow);

        }
    }
}
