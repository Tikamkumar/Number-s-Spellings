package com.tikamkumar.numbersspellings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class Blackboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blackboard)
        val numSpll: TextView = findViewById(R.id.NumSpll)
        val equal: TextView = findViewById(R.id.equal)
        val mathNUm: TextView = findViewById(R.id.NumMath)
        val title: TextView = findViewById(R.id.tablenum)
        val back: ImageButton = findViewById(R.id.back)
        back.setOnClickListener {
            finish()
        }
        val maThNum = intent.getStringExtra("OneTen")
        val numSplling = intent.getStringExtra("Numspll")
        val equall = intent.getStringExtra("Equal")
        val tableNum = intent.getStringExtra("titleName")
        title.text = tableNum
        numSpll.text = numSplling
        equal.text = equall
        mathNUm.text = maThNum
        val allClr: ImageView = findViewById(R.id.allclear)
        allClr.setOnClickListener {
            numSpll.text = ""
            equal.text = ""
            mathNUm.text = ""
            title.text = ""
        }
        val chock: ImageView = findViewById(R.id.chock)
        chock.setOnClickListener {
            title.text = tableNum
            numSpll.text = numSplling
            equal.text = equall
            mathNUm.text = maThNum
        }
    }
}

