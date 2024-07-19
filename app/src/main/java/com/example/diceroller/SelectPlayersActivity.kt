package com.example.diceroller

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class SelectPlayersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_players)

        val playersSpinner: Spinner = findViewById(R.id.players_spinner)
        val nextButton: Button = findViewById(R.id.next_button)

        nextButton.setOnClickListener {
            val numberOfPlayers = playersSpinner.selectedItem.toString().toInt()
            val intent = Intent(this, SelectDiceActivity::class.java).apply {
                putExtra("NUMBER_OF_PLAYERS", numberOfPlayers)
            }
            startActivity(intent)
        }
    }
}
