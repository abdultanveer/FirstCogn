package com.abdul.firstcogn;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import kotlin.jvm.internal.Lambda;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.LangViewHolder> {
    public static  String TAG = LanguageAdapter.class.getSimpleName();

    String[] mLanguages;
    public LanguageAdapter(String[] languages) {
        mLanguages = languages;
        Log.i(TAG,"constructor");
    }

    @NonNull
    @Override //ayman - buy the row planks from market
    public LangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG,"onCreateViewHolder - ayman buying a plank");

        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_plank,parent,false);
        return new LangViewHolder(rowView);
    }

    @Override //john -- handwriting -- write the data on the planks textview
    public void onBindViewHolder(@NonNull LangViewHolder holder, int position) {
        Log.i(TAG,"onBindViewHolder - john writing on plank--" + mLanguages[position]);

        holder.rowTextview.setText(mLanguages[position]);

    }

    @Override //christine -- keep the count of no items in the data
    public int getItemCount() {
        Log.i(TAG,"getItemCount - christine keeping a count");

        return mLanguages.length;

    }

    //derek -- maintains the box containing row planks
    class LangViewHolder extends RecyclerView.ViewHolder {
        TextView rowTextview;
        public LangViewHolder(@NonNull View rowViewPlank) {
            super(rowViewPlank);
            Log.i(TAG,"LangViewHolder - derek maintaining viewholder");

            rowTextview = rowViewPlank.findViewById(R.id.tvRow);

        }
    }
}
