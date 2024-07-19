package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    private var currentPlayer = 1
    private lateinit var resultsAdapter: ResultsAdapter
    private val resultsList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val diceSides = intent.getIntExtra("DICE_SIDES", 6)
        val numberOfPlayers = intent.getIntExtra("NUMBER_OF_PLAYERS", 2)

        val currentPlayerTextView: TextView = findViewById(R.id.current_player_text)
        val rollDiceButton: Button = findViewById(R.id.roll_dice_button)
        val rollResultTextView: TextView = findViewById(R.id.roll_result_text)
        val resultsListView: ListView = findViewById(R.id.results_list_view)

        resultsAdapter = ResultsAdapter(this, resultsList)
        resultsListView.adapter = resultsAdapter

        rollDiceButton.setOnClickListener {
            val rollResult = Random.nextInt(1, diceSides + 1)
            rollResultTextView.text = "Roll Result: $rollResult"

            resultsList.add("Player $currentPlayer: $rollResult")
            resultsAdapter.notifyDataSetChanged()

            currentPlayer = if (currentPlayer < numberOfPlayers) currentPlayer + 1 else 1
            currentPlayerTextView.text = "Current Player: $currentPlayer"
        }
    }
}
