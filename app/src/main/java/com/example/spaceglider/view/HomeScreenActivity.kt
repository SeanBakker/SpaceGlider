package com.example.spaceglider.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.spaceglider.R
import com.example.spaceglider.game.SpaceGliderApplication
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.home_screen.*
import androidx.appcompat.app.ActionBar

/*
Created By Sean Bakker
*/

class HomeScreenActivity : AppCompatActivity() {

    private lateinit var gameModeButtons: List<Button>
    private var spaceGliderApplication = SpaceGliderApplication()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen)

        //Setup welcome bar at the top of the home screen
        val customWelcomeBar: ActionBar? = supportActionBar
        customWelcomeBar?.setDisplayShowCustomEnabled(true)
        customWelcomeBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        customWelcomeBar?.setCustomView(R.layout.welcome_bar)

        gameModeButtons = listOf(ClassicButton)

        //Read Home Screen button input
        gameModeButtons.forEachIndexed { index, button ->
            button.setOnClickListener {
                spaceGliderApplication.setGameMode(index)

                val intent = Intent(this@HomeScreenActivity, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                customWelcomeBar?.hide()
                startActivity(intent)
            }
        }
    }
}