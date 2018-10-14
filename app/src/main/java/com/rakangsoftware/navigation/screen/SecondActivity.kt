package com.rakangsoftware.navigation.screen

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.rakangsoftware.navigation.R

class SecondActivity : AppCompatActivity() {
    companion object {
        fun start(context: Context){
            context.startActivity(Intent(context, SecondActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)



    }
}
