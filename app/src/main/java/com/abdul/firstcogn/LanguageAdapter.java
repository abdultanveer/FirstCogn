package com.abdul.firstcogn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.LangViewHolder> {

    @NonNull
    @Override //ayman - buy the row planks from market
    public LangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_plank,parent,false);
        return rowView;
    }

    @Override
    public void onBindViewHolder(@NonNull LangViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class LangViewHolder{}
}
