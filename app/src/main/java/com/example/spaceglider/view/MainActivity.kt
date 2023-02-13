package com.example.spaceglider.view

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.spaceglider.R
import com.example.spaceglider.game.SpaceGliderApplication
import com.example.spaceglider.view.custom.SpaceGliderView
import com.example.spaceglider.viewmodel.SpaceGliderViewModel
import kotlinx.android.synthetic.main.activity_main.*

/*
Application Created By Sean Bakker
*/

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: SpaceGliderViewModel
    private var spaceGliderApplication = SpaceGliderApplication()

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //SpaceGliderView.registerListener(this)

        /*
        viewModel = ViewModelProviders.of(this).get(SpaceGliderViewModel::class.java)
        viewModel.spaceGliderGame.selectedCellLiveData.observe(this, { updateSelectedCellUI(it) })
        viewModel.spaceGliderGame.cellsLiveData.observe(this, { updateCells(it) })
        viewModel.spaceGliderGame.isTakingNotesLiveData.observe(this, { updateNoteTakingUI(it) })
        viewModel.spaceGliderGame.highlightedKeysLiveData.observe(this, { updateHighlightedKeys(it) })
        */

        //TODO: Add movement to the ship upon hitting a button

        //Listener for upButton
        upButton.setOnClickListener {

        }

        //Listener for downButton
        downButton.setOnClickListener {

        }

        //Listener for rightButton
        rightButton.setOnClickListener {

        }

        //Listener for leftButton
        leftButton.setOnClickListener {

        }

        /*
        submit_game.setOnClickListener {

            //Check for finished game board
            val fullBoard = viewModel.sudokuGame.checkFull(viewModel.sudokuGame.getCells())
            hint.setTextColor(Color.TRANSPARENT)

            //When fullBoard is true, we check for a winning game board
            if (fullBoard) {
                val result = viewModel.sudokuGame.checkWin(viewModel.sudokuGame.getCells())

                //Post game result screen based on winning/losing board
                spaceGliderApplication.setGameResult(result)
                hints = 0

                //Call GameResultActivity()
                val intent = Intent(this@MainActivity, GameResultActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                startActivity(intent)
            }
            else {
                //Board is not complete
                boardNotComplete.setTextColor(Color.WHITE)
            }
        }
         */
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
}