package com.arshapshap.forcegestures.forcescale

import android.annotation.SuppressLint
import android.view.ScaleGestureDetector
import android.view.View

@SuppressLint("ClickableViewAccessibility")
fun View.setOnForceScaleListener(listener: OnForceScaleListener) {
    val scaleListener = ScaleListener { listener.onForceScale(this, it) }
    val scaleDetector = ScaleGestureDetector(context, scaleListener)
    setOnTouchListener { _, event ->
        scaleListener.motionEvent = event
        scaleDetector.onTouchEvent(event)
        return@setOnTouchListener true
    }
}