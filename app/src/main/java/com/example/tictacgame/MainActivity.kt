package com.example.tictacgame

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private  lateinit var  btn1 : Button
    private  lateinit var  btn2 : Button
    private  lateinit var  btn3 : Button
    private  lateinit var  btn4 : Button
    private  lateinit var  btn5 : Button
    private  lateinit var  btn6 : Button
    private  lateinit var  btn7 : Button
    private  lateinit var  btn8 : Button
    private  lateinit var  btn9 : Button
    private  lateinit var  btnStart : Button
    private  lateinit var btnJoin: Button
    private lateinit var winnerText : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btnStart = findViewById(R.id.btnStart)
        btnJoin = findViewById(R.id.btnJoin)
        winnerText = findViewById(R.id.winnerText)

        btnStart.setOnClickListener{
            enableButtons()
        }

        btnJoin.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    fun btnClick(v: View){
        val buSelected: Button = v as Button
        var cellId = 0
        when(buSelected.id){
            R.id.btn1 -> cellId = 1
            R.id.btn2 -> cellId = 2
            R.id.btn3 -> cellId = 3
            R.id.btn4 -> cellId = 4
            R.id.btn5 -> cellId = 5
            R.id.btn6 -> cellId = 6
            R.id.btn7 -> cellId = 7
            R.id.btn8 -> cellId = 8
            R.id.btn9 -> cellId = 9

        }

        Toast.makeText(this, "id: $cellId", Toast.LENGTH_SHORT).show()
        plaGame(cellId, buSelected)
    }

    private fun plaGame(cellId: Int, buSelected: Button) {

        if(activePlayer == 1){
            buSelected.text = "X"
            player1.add(cellId)
            activePlayer = 2
        }else{
            buSelected.text = "O"
            player2.add(cellId)
            activePlayer = 1
        }
        buSelected.isEnabled = false
        checkWinner()

    }

    private fun checkWinner() {
        var winner  = -1

        // Rows check
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }

        //coloums check
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }

        // Diagonal check

        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2
        }
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner = 2
        }

        if(winner != -1){
            if(winner == 1){
                Toast.makeText(this, "Winner is Player 1", Toast.LENGTH_SHORT).show()
                winnerText.visibility = View.VISIBLE
                winnerText.text = "Winner is Player 1"
                disableButtons()
            }else{
                Toast.makeText(this, "Winner is Player 2", Toast.LENGTH_SHORT).show()
                winnerText.visibility = View.VISIBLE
                winnerText.text = "Winner is Player 2"
                disableButtons()
            }
        }
    }

    private fun disableButtons(){
            btn1.isEnabled = false
            btn2.isEnabled = false
            btn3.isEnabled = false
            btn4.isEnabled = false
            btn5.isEnabled = false
            btn6.isEnabled = false
            btn7.isEnabled = false
            btn8.isEnabled = false
            btn9.isEnabled = false
    }
    private fun enableButtons(){

        player1.clear()
        player2.clear()
        activePlayer = 1
        btn1.text = " "
        btn2.text = " "
        btn3.text = " "
        btn4.text = " "
        btn5.text = " "
        btn6.text = " "
        btn7.text = " "
        btn8.text = " "
        btn9.text = " "
        btn1.isEnabled = true
        btn2.isEnabled = true
        btn3.isEnabled = true
        btn4.isEnabled = true
        btn5.isEnabled = true
        btn6.isEnabled = true
        btn7.isEnabled = true
        btn8.isEnabled = true
        btn9.isEnabled = true
    }
}