package com.rakangsoftware.navigation.screen

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.rakangsoftware.navigation.R

class ThirdActivity : AppCompatActivity() {
    companion object {
        fun start(context: Context){
            context.startActivity(Intent(context, ThirdActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_activity)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)


        supportActionBar?.apply {
        //    title = "A Navigation "
         //   subtitle = "Toolbar, bottom, up and drawer navigation"
            setDisplayHomeAsUpEnabled(true)
         //   setHomeAsUpIndicator(R.drawable.abc_ic_menu_overflow_material)
        }


    }//onCreate


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }


}
