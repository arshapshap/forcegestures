package com.arshapshap.forcegestures.longforceclick

import android.annotation.SuppressLint
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import com.arshapshap.forcegestures.DEFAULT_FORCE_TOUCH_THRESHOLD
import com.arshapshap.forcegestures.PressureHelper

@SuppressLint("ClickableViewAccessibility")
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
    setOnTouchListener { _, event -> gestureDetector.onTouchEvent(event) }
}