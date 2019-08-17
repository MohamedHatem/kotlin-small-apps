package com.me.tictactoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


// TODO: Need to enhance the game.
class MainActivity : AppCompatActivity() {


    var activePlayer = 1
    val player1 = ArrayList<Int>()
    val player2 = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun buClick(view: View) {
        val buSelected = view as Button
        var cellId = when (buSelected.id) {
            R.id.bu1 -> 1
            R.id.bu2 -> 2
            R.id.bu3 -> 3
            R.id.bu4 -> 4
            R.id.bu5 -> 5
            R.id.bu6 -> 6
            R.id.bu7 -> 7
            R.id.bu8 -> 8
            R.id.bu9 -> 9
            else -> 0
        }
        playGame(cellId, buSelected)
    }


    fun playGame(cellId: Int, buSelected: Button) {

        if (activePlayer == 1) {
            buSelected.text = "X"
            buSelected.setBackgroundResource(R.color.blue)
            activePlayer = 2
            player1.add(cellId)
            autoPlay()
        } else {
            buSelected.text = "O"
            buSelected.setBackgroundResource(R.color.darkgreen)
            activePlayer = 1
            player2.add(cellId)
        }

        buSelected.isEnabled = false
        checkWinner()
    }

    fun checkWinner() {
        var winner = -1

        // row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }


        // row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }


        // row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }


        // col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }


        // col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }


        // col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }


        if (winner != -1) {

            if (winner == 1) {
                Toast.makeText(this, " Player 1  win the game", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, " Player 2  win the game", Toast.LENGTH_LONG).show()

            }

        }
    }


    fun autoPlay() {

        val emptyCells = ArrayList<Int>()

        for (cellId in 1..9)
            if (!player1.contains(cellId) && !player2.contains(cellId))
                emptyCells.add(cellId)

        val r = Random()
        val randomIdx = r.nextInt(emptyCells.size)
        val cellId = emptyCells[randomIdx]

        var selectedBn: Button = when (cellId) {
            1 -> bu1
            2 -> bu2
            3 -> bu3
            4 -> bu4
            5 -> bu5
            6 -> bu6
            7 -> bu7
            8 -> bu8
            9 -> bu9
            else -> bu1
        }

        playGame(cellId, selectedBn)
    }


}
