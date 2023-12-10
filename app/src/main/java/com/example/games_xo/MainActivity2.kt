package com.example.games_xo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil

class MainActivity2 : AppCompatActivity() {
    lateinit var retour : Button
    lateinit var txt : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        txt = findViewById(R.id.resultat)
        retour = findViewById(R.id.retourBtn)

        txt.text = winnerPlayerTxt

        retour.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    companion object {
       var winnerPlayerTxt = ""
    }
}