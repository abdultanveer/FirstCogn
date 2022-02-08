package com.abdul.firstcogn

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.EditText
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    lateinit var homeTv:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        homeTv = findViewById(R.id.tvHome)
        //       String name = getIntent().getExtras().getString("namekey");
       var name = intent.extras?.getString("namekey")
        homeTv.text = name
    }

    fun handleClick(view: android.view.View) {
        when(view.id){
            R.id.btnDial -> {startDialer()}
            R.id.btnTimer -> {startTimer("milk", 10)}
        }

    }

    fun startTimer(message: String, seconds: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_TIMER).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_LENGTH, seconds)
            putExtra(AlarmClock.EXTRA_SKIP_UI, true)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun startDialer() {
        var dIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456")) //implicit intent

        startActivity(dIntent)
    }

    fun closeActivity(view: android.view.View) { //step 2
        //send the contact back to main activity
        var etContact = findViewById<EditText>(R.id.etContact)
        var phno = etContact.text.toString()
        var dataIntent : Intent = Intent()
        dataIntent.putExtra("phonenum", phno)
        setResult(RESULT_OK,dataIntent)
        finish()
    }
}