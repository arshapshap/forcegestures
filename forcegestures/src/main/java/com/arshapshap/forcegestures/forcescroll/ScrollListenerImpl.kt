package com.arshapshap.forcegestures.forcescroll

import android.view.MotionEvent
import android.view.View
import com.arshapshap.forcegestures.PressureHelper

/**
 * An implementation of the [View.OnTouchListener] interface that handles continuous force scroll events on a [View].
 * This class is used by the [View.setOnForceScrollListener] extension function to set up the appropriate touch listeners
 * and dispatch events to the provided [OnForceScrollListener].
 *
 * @property listener The [OnForceScrollListener] instance that will receive the force scroll events, or null if no listener is set.
 */
class ScrollListenerImpl(
    private val listener: OnForceScrollListener?
) : View.OnTouchListener {

    private var start = Point(0f, 0f)
    private var last = Point(0f, 0f)

    override fun onTouch(view: View, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                start = Point(event.x, event.y)
                last = Point(start.x, start.y)
            }

            MotionEvent.ACTION_MOVE -> {
                val velocityX = (last.x - event.x) * PressureHelper.getPressureDeviance(event)
                val velocityY = (last.y - event.y) * PressureHelper.getPressureDeviance(event)
                listener?.onForceScroll(view, velocityX, velocityY)
                last = Point(event.x, event.y)
            }

            MotionEvent.ACTION_UP -> {
                view.performClick()
            }
        }
        return true
    }
}

private data class Point(
    val x: Float,
    val y: Float
)