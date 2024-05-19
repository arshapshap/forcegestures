package com.arshapshap.forcegestures.forcescale

import android.view.MotionEvent
import android.view.ScaleGestureDetector
import com.arshapshap.forcegestures.PressureHelper

private const val MITIGATION_FACTOR = 0.1f
class ScaleListener(
    private val onPinch: (Float) -> Unit
) : ScaleGestureDetector.SimpleOnScaleGestureListener() {

    internal var motionEvent: MotionEvent? = null

    override fun onScale(detector: ScaleGestureDetector): Boolean {
        var scaleFactor = detector.scaleFactor
        motionEvent?.let {
            val deviance = (PressureHelper.getPressureDeviance(it) - 1) * MITIGATION_FACTOR + 1
            scaleFactor = if (scaleFactor >= 1) maxOf(scaleFactor, scaleFactor * deviance)
                else minOf(scaleFactor, scaleFactor / deviance)
        }
        onPinch.invoke(scaleFactor)
        return true
    }
}