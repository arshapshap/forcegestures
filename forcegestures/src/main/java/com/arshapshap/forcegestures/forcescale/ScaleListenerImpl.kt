package com.arshapshap.forcegestures.forcescale

import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import android.view.View.OnTouchListener

/**
 * An implementation of the [View.OnTouchListener] interface that handles scale events on a [View].
 * This class is used internally by the [View.setOnForceScaleListener] extension function to set up the appropriate touch listeners
 * and dispatch events to the provided [OnForceScaleListener].
 *
 * @param view The [View] on which the touch events will be handled.
 * @param listener The [OnForceScaleListener] instance that will receive the scale events.
 */
class ScaleListenerImpl(
    view: View,
    listener: OnForceScaleListener?
) : OnTouchListener {

    private val scaleListener = ScaleGestureListener { listener?.onForceScale(view, it) }
    private val scaleDetector = ScaleGestureDetector(view.context, scaleListener)

    override fun onTouch(view: View, event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_UP)
            view.performClick()
        scaleListener.motionEvent = event
        scaleDetector.onTouchEvent(event)
        return true
    }
}