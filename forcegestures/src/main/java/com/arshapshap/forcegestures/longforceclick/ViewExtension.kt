package com.arshapshap.forcegestures.longforceclick

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import com.arshapshap.forcegestures.DEFAULT_FORCE_TOUCH_THRESHOLD
import com.arshapshap.forcegestures.PressureHelper

fun View.setOnLongForceClickListener(
    listener: OnLongForceClickListener?,
    threshold: Float = DEFAULT_FORCE_TOUCH_THRESHOLD
) {
    val view = this
    val gestureDetector =
        GestureDetector(this.context, object : GestureDetector.SimpleOnGestureListener() {

            override fun onLongPress(event: MotionEvent) {
                if (PressureHelper.isForceTouch(event, threshold))
                    listener?.onLongForceClick(view)
                else
                    listener?.onLongNormalClick(view)
                performLongClick()
            }
        })
    setOnTouchListener { _, event ->
        if (event.action == MotionEvent.ACTION_DOWN)
            performClick()
        gestureDetector.onTouchEvent(event)
    }
}