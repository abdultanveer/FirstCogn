package com.abdul.firstcogn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mTextView = new TextView(this);
        mTextView.setText("text from java");

        ConstraintLayout cl = findViewById(R.id.container);
        cl.addView(mTextView);
    }
}