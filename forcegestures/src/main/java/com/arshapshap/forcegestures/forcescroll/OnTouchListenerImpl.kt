package com.arshapshap.forcegestures.forcescroll

import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import com.arshapshap.forcegestures.PressureHelper

internal class OnTouchListenerImpl(
    private val orientation: Int = LinearLayout.VERTICAL,
    private val onScroll: (Float) -> Unit
) : View.OnTouchListener {

    private var startX = 0f
    private var startY = 0f
    private var lastX = 0f
    private var lastY = 0f

    override fun onTouch(view: View, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                startX = event.x
                startY = event.y
                lastX = startX
                lastY = startY
            }

            MotionEvent.ACTION_MOVE -> {
                val velocityX = (lastX - event.x) * PressureHelper.getPressureDeviance(event)
                val velocityY = (lastY - event.y) * PressureHelper.getPressureDeviance(event)
                onScroll.invoke(if (orientation == LinearLayout.VERTICAL) velocityY else velocityX)
                lastY = event.y
            }
        }
        return true
    }
}