package com.lharo.exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_Movie = findViewById<Button>(R.id.btn_Movie)

        btn_Movie.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val intent = when(view.id){
            R.id.btn_Movie -> Intent(this, MoviesActivity::class.java)
            else -> throw IllegalArgumentException("Invalid Button")
        }
        startActivity(intent)
    }
}