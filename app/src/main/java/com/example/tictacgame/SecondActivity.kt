package com.example.tictacgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

class SecondActivity : AppCompatActivity() {
    private  lateinit var  button1 : Button
    private  lateinit var   button2 : Button
    private  lateinit var   button3 : Button
    private  lateinit var   button4 : Button
    private  lateinit var   button5 : Button
    private  lateinit var  button6 : Button
    private  lateinit var  button7 : Button
    private  lateinit var  button8 : Button
    private  lateinit var   button9 : Button
    private lateinit var winnerText : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val toolBar = supportActionBar
        toolBar?.setDisplayHomeAsUpEnabled(true)

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        winnerText = findViewById(R.id.winnerText2)
        choosePlayer()
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1
    var setPlayer = 1
    fun btnClick(v: View){
        val buSelected: Button = v as Button
        var cellId = 0
        when(buSelected.id){
            R.id.button1 -> cellId = 1
            R.id.button2 -> cellId = 2
            R.id.button3 -> cellId = 3
            R.id.button4 -> cellId = 4
            R.id.button5 -> cellId = 5
            R.id.button6-> cellId = 6
            R.id.button7 -> cellId = 7
            R.id.button8 -> cellId = 8
            R.id.button9 -> cellId = 9

        }

        Toast.makeText(this, "id: $cellId", Toast.LENGTH_SHORT).show()
        plaGame(cellId, buSelected)
    }

    fun choosePlayer(){
        setPlayer = 2
    }
    private fun plaGame(cellId: Int, buSelected: Button) {

        if(activePlayer == 1){
            buSelected.text = "X"
            player1.add(cellId)
            activePlayer = 2
            if (setPlayer == 1)
            {}
            else
            {
                try {
                    AutoPlay()
                }catch (ex:Exception)
                {
                    Toast.makeText(this,"Game Over",Toast.LENGTH_SHORT).show()
                }

            }
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
            if (winner == 1)
            {
                if(setPlayer == 1) {
                    winnerText.visibility = View.VISIBLE
                    winnerText.text = "Player 1 Wins!!"
                    Toast.makeText(this, "Player 1 Wins!!", Toast.LENGTH_SHORT).show()
                    disableButtons()
                }
                else
                {
                    winnerText.visibility = View.VISIBLE
                    winnerText.text = "You Won!!"
                    Toast.makeText(this, "You Won!!", Toast.LENGTH_SHORT).show()
                    disableButtons()
                }
            }
            else
            {
                if (setPlayer == 1) {
                    winnerText.visibility = View.VISIBLE
                    winnerText.text = "Player 2 Wins!!"
                    Toast.makeText(this, "Player 2 Wins!!", Toast.LENGTH_SHORT).show()
                    disableButtons()
                }
                else
                {
                    winnerText.visibility = View.VISIBLE
                    winnerText.text = "You Lost!!"
                    Toast.makeText(this, "You Lost!!", Toast.LENGTH_SHORT).show()
                    disableButtons()
                }
            }
        }
    }

    fun AutoPlay()
    {
        val emptyCells = ArrayList<Int>()
        for (cellId in 1..9) {
            if (player1.contains(cellId) || player2.contains(cellId))
            {}
            else
            {
                emptyCells.add(cellId)
            }
        }

        val r = Random()
        val randomIndex = r.nextInt(emptyCells.size-0)+0
        val cellId = emptyCells[randomIndex]

        val buSelect:Button?
        when(cellId)
        {
            1 -> buSelect = button1
            2 -> buSelect = button2
            3 -> buSelect = button3
            4 -> buSelect = button4
            5 -> buSelect = button5
            6 -> buSelect = button6
            7 -> buSelect = button7
            8 -> buSelect = button8
            9 -> buSelect = button9
            else -> buSelect = button1
        }

        plaGame(cellId, buSelect)
    }
    private fun disableButtons(){
        button1.isEnabled = false
        button1.isEnabled = false
        button1.isEnabled = false
        button1.isEnabled = false
        button1.isEnabled = false
        button1.isEnabled = false
        button1.isEnabled = false
        button1.isEnabled = false
        button1.isEnabled = false
    }
    override fun onSupportNavigateUp(): Boolean {
        this.finish()
        return super.onSupportNavigateUp()
    }
}