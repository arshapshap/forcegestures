package com.arshapshap.forcegestures.forceswipe

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import com.arshapshap.forcegestures.ForceGesturesInformer
import com.arshapshap.forcegestures.PressureHelper

/**
 * An implementation of the [View.OnTouchListener] interface that handles swipe events on a [View].
 * This class is used internally by the [View.setOnForceSwipeListener] extension function to set up the appropriate touch listeners
 * and dispatch events to the provided [OnForceSwipeListener].
 *
 * @param view The [View] on which the touch events will be handled.
 * @param listener The [OnForceSwipeListener] instance that will receive the swipe events, or null if no listener is set.
 * @param threshold The force touch pressure threshold value (in the range 0.0 to 1.0) to distinguish between a force swipe and a normal swipe.
 */
class SwipeListenerImpl(
    view: View,
    listener: OnForceSwipeListener?,
    threshold: Float
) : OnTouchListener {

    private val gestureDetector =
        GestureDetector(view.context, object : GestureDetector.SimpleOnGestureListener() {

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

    override fun onTouch(view: View, event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_UP)
            view.performClick()
        return gestureDetector.onTouchEvent(event)
    }
}