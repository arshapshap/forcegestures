package com.arshapshap.forcegestures.forceclick

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View
import com.arshapshap.forcegestures.PressureHelper


@SuppressLint("ClickableViewAccessibility")
fun View.setOnForceClickListener(listener: OnForceClickListener?) {
    setOnTouchListener { view, event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                if (PressureHelper.isForceTouch(event))
                    listener?.onForceClick(view)
                else
                    listener?.onNormalClick(view)
            }
        }
        false
    }
}