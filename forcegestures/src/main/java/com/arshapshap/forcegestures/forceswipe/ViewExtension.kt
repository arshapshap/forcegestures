package com.arshapshap.forcegestures.forceswipe

import android.annotation.SuppressLint
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import com.arshapshap.forcegestures.PressureHelper
import com.arshapshap.forcegestures.longforceclick.setOnLongForceClickListener

@SuppressLint("ClickableViewAccessibility")
fun View.setOnForceSwipeListener(listener: OnForceSwipeListener?) {
    val view = this
    val gestureDetector =
        GestureDetector(this.context, object : GestureDetector.SimpleOnGestureListener() {

            override fun onFling(
                e1: MotionEvent?,
                e2: MotionEvent,
                velocityX: Float,
                velocityY: Float
            ): Boolean {
                if (e1 == null)
                    return false
                if (PressureHelper.isForceTouch(e1))
                    listener?.onForceSwipe(view)
                else
                    listener?.onNormalSwipe(view)
                return super.onFling(e1, e2, velocityX, velocityY)
            }
        })
    setOnTouchListener { _, event -> gestureDetector.onTouchEvent(event) }
}