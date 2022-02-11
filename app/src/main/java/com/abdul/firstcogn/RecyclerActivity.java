package com.abdul.firstcogn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

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
        lRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        lRecyclerView.setAdapter(adapter);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "show dialog to close", Toast.LENGTH_SHORT).show();
    }
}