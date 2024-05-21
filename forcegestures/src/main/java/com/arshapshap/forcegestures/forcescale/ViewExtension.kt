package com.arshapshap.forcegestures.forcescale

import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View

fun View.setOnForceScaleListener(listener: OnForceScaleListener) {
    val scaleListener = ScaleListener { listener.onForceScale(this, it) }
    val scaleDetector = ScaleGestureDetector(context, scaleListener)
    setOnTouchListener { _, event ->
        if (event.action == MotionEvent.ACTION_DOWN)
            performClick()
        scaleListener.motionEvent = event
        scaleDetector.onTouchEvent(event)
        return@setOnTouchListener true
    }
}