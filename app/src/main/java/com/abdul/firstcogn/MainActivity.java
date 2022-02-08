package com.abdul.firstcogn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener {
    EditText nameEditText; //declaration
    public static  String TAG = MainActivity.class.getSimpleName();
                //"MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //inflation
        nameEditText = findViewById(R.id.etName); //initialized it -- getting handle

        nameEditText.setOnFocusChangeListener(this); //this referes to the current instance of this class

        TextView mTextView = new TextView(this);
        mTextView.setText("text from java");

        ConstraintLayout cl = findViewById(R.id.container);
        cl.addView(mTextView);
    }

    public void clickHandler(View view) {
        String value = nameEditText.getText().toString();
        Intent hIntent = new Intent(this,HomeActivity.class);
        hIntent.putExtra("namekey",value);
        startActivity(hIntent);
       /*    //using nameEdittext here
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();*/
    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        if(hasFocus){
            Toast.makeText(this, "got focus", Toast.LENGTH_SHORT).show();
            Log.i(TAG,"has focus");
        }
        else {
            Toast.makeText(this, R.string.enter_pass, Toast.LENGTH_SHORT).show();
            Log.i(TAG,"lost focus");

        }
    }
}