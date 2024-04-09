package com.arshapshap.forcegestures.forceclick

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View
import com.arshapshap.forcegestures.common.setHotspot


@SuppressLint("ClickableViewAccessibility")
fun View.setOnForceClickListener(listener: OnForceClickListener?) {
    setOnTouchListener { view, event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                if (event.pressure < 0.22f)
                    listener?.onNormalClick(this)
                else
                    listener?.onForceClick(this)
            }
        }
        false
    }
}