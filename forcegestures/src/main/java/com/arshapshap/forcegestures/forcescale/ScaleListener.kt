package com.arshapshap.forcegestures.forcescale

import android.view.MotionEvent
import android.view.ScaleGestureDetector
import com.arshapshap.forcegestures.PressureHelper

class ScaleListener(
    private val onPinch: (Float) -> Unit
) : ScaleGestureDetector.SimpleOnScaleGestureListener() {

    internal var motionEvent: MotionEvent? = null

    override fun onScale(detector: ScaleGestureDetector): Boolean {
        var scaleFactor = detector.scaleFactor
        motionEvent?.let {
            val deviance = (PressureHelper.getPressureDeviance(it) - 1) * 0.1f + 1
            scaleFactor *= if (scaleFactor >= 1) deviance else 1/deviance
        }
        onPinch.invoke(scaleFactor)
        return true
    }
}