package com.abdul.firstcogn;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener {
    EditText nameEditText; //declaration
    Student abdul;  //a ref variable is created on the stack memory
    public static  String TAG = MainActivity.class.getSimpleName();
                //"MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //inflation
        abdul = new Student("ansari",123,3445); //this will create the object on heap memory

        nameEditText = findViewById(R.id.etName); //initialized it -- getting handle

        nameEditText.setOnFocusChangeListener(this); //this referes to the current instance of this class

        TextView mTextView = new TextView(this);
        mTextView.setText("text from java");

        ConstraintLayout cl = findViewById(R.id.container);
        cl.addView(mTextView);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void clickHandler(View view) {
        switch (view.getId()){
            case R.id.button:
                startHome();
                break;
            case R.id.btnAlarm:
                createAlarm("midnight",00,49);
                break;
        }
       // startHome();

    }

    public void createAlarm(String message, int hour, int minutes) {
        //Util myUtil = new Util();
        //Util.add(10,20);
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void startHome() {
        String value = nameEditText.getText().toString();
        Intent hIntent = new Intent(this, HomeActivity.class); //explicit intent
        hIntent.putExtra("namekey",value);
        startActivityForResult(hIntent,123); //step 1
        Log.i(TAG, "starting homeactivity");
    }
  //because in whatsapp chat.. you can go to fetch a contact/photo, location
    //the point of return is same ie onActivityResult how do i differentiate which data you're getting
    //that differentiation is made using the request
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {  //dataIntent
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(TAG, "onActivityResult");

        if(requestCode == 123){
          String phno =  data.getExtras().getString("phonenum");
          TextView tvMain = findViewById(R.id.tvMain);
          tvMain.setText(phno);
        }
    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        if(hasFocus){
            Toast.makeText(this, "got focus", Toast.LENGTH_SHORT).show(); //this = instance of MainActivity()
            Log.i(TAG,"has focus");
        }
        else {
            Toast.makeText(this, R.string.enter_pass, Toast.LENGTH_SHORT).show();
            Log.i(TAG,"lost focus");

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
         getMenuInflater().inflate(R.menu.home_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         super.onOptionsItemSelected(item);
         switch (item.getItemId()){
             case R.id.ngroup:

                 break;
             case R.id.settings:
                 break;
         }
        return true;
    }
}