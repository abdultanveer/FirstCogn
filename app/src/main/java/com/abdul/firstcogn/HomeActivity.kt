package com.abdul.firstcogn

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        var dIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456")) //implicit intent

        startActivity(dIntent)
    }
}