package com.arshapshap.forcegestures.doubleforceclick

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import com.arshapshap.forcegestures.DEFAULT_FORCE_TOUCH_THRESHOLD
import com.arshapshap.forcegestures.PressureHelper

fun View.setOnDoubleForceClickListener(
    listener: OnDoubleForceClickListener?,
    threshold: Float = DEFAULT_FORCE_TOUCH_THRESHOLD
) {
    val view = this
    val gestureDetector =
        GestureDetector(this.context, object : GestureDetector.SimpleOnGestureListener() {

            override fun onDoubleTap(event: MotionEvent): Boolean {
                if (PressureHelper.isForceTouch(event, threshold))
                    listener?.onDoubleForceClick(view)
                else
                    listener?.onDoubleNormalClick(view)
                return super.onDoubleTap(event)
            }
        })
    setOnTouchListener { _, event ->
        if (event.action == MotionEvent.ACTION_DOWN)
            performClick()
        gestureDetector.onTouchEvent(event)
    }
}