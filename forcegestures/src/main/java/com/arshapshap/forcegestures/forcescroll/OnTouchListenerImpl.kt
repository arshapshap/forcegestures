package com.arshapshap.forcegestures.forcescroll

import android.view.MotionEvent
import android.view.View
import com.arshapshap.forcegestures.PressureHelper

internal class OnTouchListenerImpl(
    private val onScroll: (Float) -> Unit
) : View.OnTouchListener {

    private var startX = 0f
    private var startY = 0f
    private var lastY = 0f

    override fun onTouch(view: View, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                startX = event.x
                startY = event.y
                lastY = startY
            }

            MotionEvent.ACTION_MOVE -> {
                val deltaY = (lastY - event.y) * PressureHelper.getPressureDeviance(event)
                onScroll.invoke(deltaY)
                lastY = event.y
            }
        }
        return true
    }
}