package com.arshapshap.forcegestures.forceswipe

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import com.arshapshap.forcegestures.DEFAULT_FORCE_TOUCH_THRESHOLD
import com.arshapshap.forcegestures.ForceGesturesInformer
import com.arshapshap.forcegestures.PressureHelper

/**
 * Sets an [OnForceSwipeListener] on this [View] to receive force swipe and normal swipe events.
 *
 * @receiver The [View] on which the listener will be set.
 * @param listener The [OnForceSwipeListener] instance to receive swipe events, or null to clear the existing listener.
 * @param threshold The force touch pressure threshold value (in the range 0.0 to 1.0) to distinguish between a force swipe and a normal swipe. Defaults to [DEFAULT_FORCE_TOUCH_THRESHOLD].
 *
 * @see OnForceSwipeListener
 */
fun View.setOnForceSwipeListener(
    listener: OnForceSwipeListener?,
    threshold: Float = DEFAULT_FORCE_TOUCH_THRESHOLD
) {
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
                if (!ForceGesturesInformer.readyToUse)
                    listener?.onUndefinedSwipe(view, velocityX, velocityY)
                else if (PressureHelper.isForceTouch(e1, threshold))
                    listener?.onForceSwipe(view, velocityX, velocityY)
                else
                    listener?.onNormalSwipe(view, velocityX, velocityY)
                return super.onFling(e1, e2, velocityX, velocityY)
            }
        })
    setOnTouchListener { _, event ->
        if (event.action == MotionEvent.ACTION_DOWN)
            performClick()
        gestureDetector.onTouchEvent(event)
    }
}