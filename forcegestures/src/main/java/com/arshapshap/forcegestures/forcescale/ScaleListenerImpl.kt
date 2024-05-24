package com.arshapshap.forcegestures.forcescale

import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import android.view.View.OnTouchListener
import com.arshapshap.forcegestures.PressureHelper

private const val MITIGATION_FACTOR = 0.1f

/**
 * An implementation of the [View.OnTouchListener] interface that handles scale events on a [View].
 * This class is used internally by the [View.setOnForceScaleListener] extension function to set up the appropriate touch listeners
 * and dispatch events to the provided [OnForceScaleListener].
 *
 * @param view The [View] on which the touch events will be handled.
 * @param listener The [OnForceScaleListener] instance that will receive the scale events.
 */
class ScaleListenerImpl(
    private val view: View,
    private val listener: OnForceScaleListener?
) : OnTouchListener, ScaleGestureDetector.SimpleOnScaleGestureListener() {

    private val scaleDetector = ScaleGestureDetector(view.context, this)
    private var motionEvent: MotionEvent? = null

    override fun onTouch(view: View, event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_UP)
            view.performClick()
        this.motionEvent = event
        scaleDetector.onTouchEvent(event)
        return true
    }

    override fun onScale(detector: ScaleGestureDetector): Boolean {
        var scaleFactor = detector.scaleFactor
        motionEvent?.let {
            val deviance = (PressureHelper.getPressureDeviance(it) - 1) * MITIGATION_FACTOR + 1
            scaleFactor = if (scaleFactor >= 1) (scaleFactor * deviance).coerceAtLeast(scaleFactor)
                else (scaleFactor / deviance).coerceAtMost(scaleFactor)
        }
        listener?.onForceScale(view, scaleFactor)
        return true
    }
}