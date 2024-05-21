package com.arshapshap.forcegestures.forcescale

import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View

/**
 * Sets an [OnForceScaleListener] on this [View] to receive continuous force scale events.
 *
 * @receiver The [View] on which the listener will be set.
 * @param listener The [OnForceScaleListener] instance to receive force scale events.
 *
 * @see OnForceScaleListener
 */
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