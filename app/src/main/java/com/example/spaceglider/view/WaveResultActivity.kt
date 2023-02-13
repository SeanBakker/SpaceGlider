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

class WaveResultActivity : AppCompatActivity() {

    private lateinit var gameModeButtons: List<Button>
    private var spaceGliderApplication = SpaceGliderApplication()
    private var spaceGliderGame = SpaceGliderGame()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_result)

        gameModeButtons = listOf(ClassicButton)

        if (spaceGliderApplication.getWaveResult()) {
            win_result.setTextColor(ContextCompat.getColor(this, R.color.gold_header))
            lose_result.setTextColor(Color.TRANSPARENT)
        }
        else {
            win_result.setTextColor(Color.TRANSPARENT)
            lose_result.setTextColor(Color.RED)
        }

        //Wait some time before starting the next wave
        //delay(1000)
        startNewGameActivity()
    }

    private fun startNewGameActivity() {
        val intent = Intent(this@WaveResultActivity, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}