package com.example.games_xo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()
    var activePlayer = 1
    var numButton = 9
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun butClicked(view:View){
        val  butSelected = view as Button
        var cmp = 0
        when(butSelected.id){
            R.id.btn1 -> cmp = 1
            R.id.btn2 -> cmp = 2
            R.id.btn3 -> cmp = 3
            R.id.btn4 -> cmp = 4
            R.id.btn5 -> cmp = 5
            R.id.btn6 -> cmp = 6
            R.id.btn7 -> cmp = 7
            R.id.btn8 -> cmp = 8
            R.id.btn9 -> cmp = 9
        }
        playGame(cmp,butSelected)
    }
    private fun playGame(cmp :Int , butSelected: Button){
        numButton -=  1
        if (activePlayer == 1){
            butSelected.background = ContextCompat.getDrawable(this,R.drawable.x_game)
            player1.add(cmp)
            activePlayer = 2
        }
        else{
            butSelected.background = ContextCompat.getDrawable(this,R.drawable.o_game)
            player2.add(cmp)
            activePlayer = 1
        }
        butSelected.isEnabled = false
        chechWinner()
    }
    private fun chechWinner(){
        var winner = 0
        if (numButton == 0){
            val intent = Intent(this,MainActivity2::class.java)
            MainActivity2.winnerPlayerTxt = "Player  X  = Player  O "
            startActivity(intent)
        }
        //Rows
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) winner = 1
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) winner =2

        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) winner = 1
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) winner =2

        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) winner = 1
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) winner =2

        //Columns
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) winner = 1
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) winner =2

        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) winner = 1
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) winner =2

        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) winner = 1
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) winner =2


        //Diagonals
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) winner = 1
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) winner =2

        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) winner = 1
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) winner =2

        if (winner == 1){
            val intent = Intent(this,MainActivity2::class.java)
            MainActivity2.winnerPlayerTxt="Player  X  is the  Winner"
            startActivity(intent)
        }
        if (winner == 2){
            val intent = Intent(this,MainActivity2::class.java)
            MainActivity2.winnerPlayerTxt="Player  O  is the Winner"
            startActivity(intent)
        }
    }
}