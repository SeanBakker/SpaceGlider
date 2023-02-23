package com.example.spaceglider.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.*
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.spaceglider.R
import com.example.spaceglider.game.SpaceGliderApplication
import com.example.spaceglider.view.custom.SpaceGliderView
import com.example.spaceglider.viewmodel.SpaceGliderViewModel
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View.OnTouchListener
import androidx.appcompat.app.ActionBar
import android.util.DisplayMetrics





/*
Application Created By Sean Bakker
*/

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    //Variables
    private lateinit var viewModel: SpaceGliderViewModel
    private var spaceGliderApplication = SpaceGliderApplication()

    //Button config variables
    private var spaceshipSpeed = 30
    private var handler: Handler? = null
    private val delay = 100
    private val upSpeed = -15F
    private val downSpeed = 15F
    private val rightSpeed = 15F
    private val leftSpeed = -15F


    @SuppressLint("ResourceAsColor", "ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //SpaceGliderView.registerListener(this)

        //Hide action bar for this activity
        val customWelcomeBar: ActionBar? = supportActionBar
        customWelcomeBar?.hide()

        //Get window size width and height
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels

        //upButton action to move the player upwards
        val upButtonAction: Runnable = object : Runnable {
            override fun run() {
                //Make sure the player is in the bounds
                if (player.y + upSpeed.toInt() > 0) {
                    //Move player upwards
                    player.animate().translationYBy(upSpeed).duration = spaceshipSpeed.toLong()
                }
                handler!!.postDelayed(this, delay.toLong())
            }
        }

        //upButton onTouchListener to trigger the action upon touch event
        upButton.setOnTouchListener(OnTouchListener { view, event ->
            buttonListener(event, upButtonAction)
        })

        //downButton action to move the player downwards
        val downButtonAction: Runnable = object : Runnable {
            override fun run() {
                //Make sure the player is in the bounds
                if (player.y + upSpeed.toInt() < height / 1.25) {
                    //Move player downwards
                    player.animate().translationYBy(downSpeed).duration = spaceshipSpeed.toLong()
                }
                handler!!.postDelayed(this, delay.toLong())
            }
        }

        //downButton onTouchListener to trigger the action upon touch event
        downButton.setOnTouchListener(OnTouchListener { view, event ->
            buttonListener(event, downButtonAction)
        })

        //rightButton action to move the player upwards
        val rightButtonAction: Runnable = object : Runnable {
            override fun run() {
                //Make sure the player is in the bounds
                if (player.x + upSpeed.toInt() < width / 2) {
                    //Move player to the right
                    player.animate().translationXBy(rightSpeed).duration = spaceshipSpeed.toLong()
                }
                handler!!.postDelayed(this, delay.toLong())
            }
        }

        //rightButton onTouchListener to trigger the action upon touch event
        rightButton.setOnTouchListener(OnTouchListener { view, event ->
            buttonListener(event, rightButtonAction)
        })

        //leftButton action to move the player upwards
        val leftButtonAction: Runnable = object : Runnable {
            override fun run() {
                //Make sure the player is in the bounds
                if (player.x + upSpeed.toInt() > 0) {
                    //Move player to the left
                    player.animate().translationXBy(leftSpeed).duration = spaceshipSpeed.toLong()
                }
                handler!!.postDelayed(this, delay.toLong())
            }
        }

        //leftButton onTouchListener to trigger the action upon touch event
        leftButton.setOnTouchListener(OnTouchListener { view, event ->
            buttonListener(event, leftButtonAction)
        })

        pauseButton.setOnClickListener {

            //TODO: Setup pause functionality
            //Display paused text to the screen


            //Pause the game

        }
    }

    //Perform actions on resuming MainActivity
    override fun onResume() {
        super.onResume()

        //Check for restart requested
        if (spaceGliderApplication.getRestart()) {
            //TODO: add any recovery on restart for game mechanics
            spaceGliderApplication.setRestart(false)
        }
    }

    private fun buttonListener(event: MotionEvent, action: Runnable) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                if (handler != null) return true
                handler = Handler()
                handler!!.postDelayed(action, 0)
            }
            MotionEvent.ACTION_UP -> {
                if (handler == null) return true
                handler!!.removeCallbacks(action)
                handler = null
            }
        }
        return false
    }
}