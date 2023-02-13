package com.example.spaceglider.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.spaceglider.R
import com.example.spaceglider.game.SpaceGliderApplication
import com.example.spaceglider.game.SpaceGliderGame
import kotlinx.android.synthetic.main.game_result.*
import kotlinx.android.synthetic.main.home_screen.*

class GameResultActivity : AppCompatActivity() {

    private lateinit var gameModeButtons: List<Button>
    private var spaceGliderApplication = SpaceGliderApplication()
    private var spaceGliderGame = SpaceGliderGame()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_result)

        gameModeButtons = listOf(ClassicButton)

        if (spaceGliderApplication.getGameResult()) {
            win_result.setTextColor(ContextCompat.getColor(this, R.color.gold_header))
            lose_result.setTextColor(Color.TRANSPARENT)
        }
        else {
            win_result.setTextColor(Color.TRANSPARENT)
            lose_result.setTextColor(Color.RED)
        }

        //Read GameResult Screen button input
        gameModeButtons.forEachIndexed { index, button ->
            button.setOnClickListener {
                spaceGliderApplication.setGameMode(index)
                startNewGameActivity()
            }
        }

        //Read input from resume game button
        ResumeButton.setOnClickListener {
            finish()
        }

        //Read input from restart game button
        RestartButton.setOnClickListener {
            //TODO: add any recovery on restart for game mechanics
            spaceGliderApplication.setRestart(true)
            finish()
        }
    }

    private fun startNewGameActivity() {
        val intent = Intent(this@GameResultActivity, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}