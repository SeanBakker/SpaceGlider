package com.example.spaceglider.game

import android.app.Application

/*
Application Created By Sean Bakker
*/

open class SpaceGliderApplication : Application() {

    companion object {
        private var gamemode = 0
        private var gameResult = false
        private var waveResult = false
        private var restart = false
    }

    fun setGameMode(newGameMode: Int) {
        gamemode = newGameMode
    }

    fun getGameMode(): Int {
        return gamemode
    }

    fun setGameResult(newGameResult: Boolean) {
        gameResult = newGameResult
    }

    fun getGameResult(): Boolean {
        return gameResult
    }

    fun setWaveResult(newWaveResult: Boolean) {
        waveResult = newWaveResult
    }

    fun getWaveResult(): Boolean {
        return waveResult
    }

    fun setRestart(newRestart: Boolean) {
        restart = newRestart
    }

    fun getRestart(): Boolean {
        return restart
    }
}