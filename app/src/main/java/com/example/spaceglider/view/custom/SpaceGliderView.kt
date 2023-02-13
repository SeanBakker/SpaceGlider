package com.example.spaceglider.view.custom

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kotlin.math.min

/*
Created By Sean Bakker
*/

class SpaceGliderView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    private var listener: OnTouchListener? = null

    //Set display of screen to be bounded by the minimum value of the width/height
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val sizePixels = min(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(sizePixels, sizePixels)
    }

    override fun onDraw(canvas: Canvas) {
        //TODO: add anything to draw / or remove
    }

    fun registerListener(listener: OnTouchListener) {
        this.listener = listener
    }
}