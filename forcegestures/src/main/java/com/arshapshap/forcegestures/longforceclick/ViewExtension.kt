package com.arshapshap.forcegestures.longforceclick

import android.annotation.SuppressLint
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

@SuppressLint("ClickableViewAccessibility")
fun View.setOnLongForceClickListener(listener: OnLongForceClickListener?) {
    val view = this
    val gestureDetector =
        GestureDetector(this.context, object : GestureDetector.SimpleOnGestureListener() {

            override fun onLongPress(event: MotionEvent) {
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        if (event.pressure < 0.22f)
                            listener?.onLongNormalClick(view)
                        else
                            listener?.onLongForceClick(view)
                    }
                }
            }
        })
    setOnTouchListener { v, event -> gestureDetector.onTouchEvent(event) }
}