package com.abdul.firstcogn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RecyclerActivity extends AppCompatActivity {
String[] languages = new String[] {"english","hindi","french","arabic",
                                   "english","hindi","french","arabic",
        "english","hindi","french","arabic", "english","hindi","french","arabic", "english","hindi","french","arabic"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler);

        RecyclerView lRecyclerView = findViewById(R.id.lrecycler_view);
        LanguageAdapter adapter = new LanguageAdapter(languages);
        lRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        lRecyclerView.setAdapter(adapter);

    }
}