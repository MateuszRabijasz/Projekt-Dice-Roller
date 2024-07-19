package com.example.diceroller

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class SelectDiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_dice)

        val numberOfPlayers = intent.getIntExtra("NUMBER_OF_PLAYERS", 2)
        val diceSpinner: Spinner = findViewById(R.id.dice_spinner)
        val startGameButton: Button = findViewById(R.id.start_game_button)

        startGameButton.setOnClickListener {
            val diceSides = diceSpinner.selectedItem.toString().toInt()
            val intent = Intent(this, GameActivity::class.java).apply {
                putExtra("DICE_SIDES", diceSides)
                putExtra("NUMBER_OF_PLAYERS", numberOfPlayers)
            }
            startActivity(intent)
        }
    }
}
