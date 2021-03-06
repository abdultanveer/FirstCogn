package com.abdul.firstcogn

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.abdul.firstcogn.javabasics.Bike2
import java.lang.NullPointerException

class HomeActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener,
    RadioGroup.OnCheckedChangeListener {
    lateinit var homeTv: TextView
    var TAG = HomeActivity::class.java.simpleName
    lateinit var cSpinner: Spinner;
    lateinit var radioGroup: RadioGroup


    //from storage to ram
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home) //layoutinflater
        //Employee.COMPANY_NAME
        cSpinner = findViewById(R.id.countriesSpinner)
        radioGroup = findViewById(R.id.radioGroup)
        radioGroup.setOnCheckedChangeListener(this)
        homeTv = findViewById(R.id.tvHome)
        Log.i(TAG, "creating")
        //       String name = getIntent().getExtras().getString("namekey");
        /*var name = intent.extras?.getString("namekey")
         homeTv.text = name*/
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when (item.itemId) {
            R.id.ngroup -> {
                Toast.makeText(this, "new group", Toast.LENGTH_SHORT).show()
                /*Bike2 obj = new Bike2();//creating object
                obj.run()*/
                var bike: Bike2 = Bike2()
                Log.i(TAG, "bike is running safe" + bike.drive())
            }
            R.id.settings -> {
                Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show()
            }
        }
        return true;
    }

    //ui is visible - user can click button
    override fun onStart() {
        super.onStart()
        cSpinner.onItemSelectedListener = this
        Log.v(TAG, "starting")
        add(10, 20);

    }

    /**
     * this method is for adding two nos
     */
    fun add(a: Int, b: Int): Int {
        return a + b
    }


    //waking up
    override fun onResume() {
        super.onResume()
        Log.w(TAG, "resuming -- restore the app state")

    }

    //partially visible --- sleep
    override fun onPause() {
        super.onPause()
        Log.i(TAG, "pausing-- store app state")

    }

    //hibernate in windows - pushed out of ram into storage , why not purge
    override fun onStop() {
        super.onStop()
        Log.e(TAG, "stopping")

    }

    //activity is purged -- no longer exists in memory or storage
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "destroying -- clean up(release resource)")

    }

    fun handleClick(view: android.view.View) {
        when (view.id) {
            R.id.btnDial -> {
                startDialer()
            }
            R.id.btnTimer -> {
                startTimer("milk", 10)
            }
            R.id.btnCalendar -> {
                startCalendar()
            }
        }

    }

    private fun startCalendar() {
        var cIntent = Intent("abdul.needs.water")
        startActivity(cIntent)
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
        Log.i(TAG, "closeActivity");
        //send the contact back to main activity
        var etContact = findViewById<EditText>(R.id.etContact)
        var phno = etContact.text.toString()
        var dataIntent: Intent = Intent()
        dataIntent.putExtra("phonenum", phno)
        setResult(RESULT_OK, dataIntent)
        finish()
    }

    override fun onItemSelected(adapter: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        var item = adapter?.getItemAtPosition(position).toString()
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }

    override fun onCheckedChanged(p0: RadioGroup?, checkedId: Int) {
        when (checkedId) {
            R.id.male -> {
                Toast.makeText(this, "male", Toast.LENGTH_SHORT).show()
            }
            R.id.female -> {
                Toast.makeText(this, "female", Toast.LENGTH_SHORT).show()
            }

        }
    }
}