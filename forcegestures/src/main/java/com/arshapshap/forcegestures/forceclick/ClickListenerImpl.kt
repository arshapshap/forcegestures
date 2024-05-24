package com.arshapshap.forcegestures.forceclick

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import com.arshapshap.forcegestures.ForceGesturesInformer
import com.arshapshap.forcegestures.PressureHelper

/**
 * An implementation of the [View.OnTouchListener] interface that handles force click, normal click,
 * and undefined click events on a [View]. This class is used internally by the [View.setOnForceClickListener]
 * extension function to set up the appropriate touch listeners and dispatch events to the provided
 * [OnForceClickListener].
 *
 * @param view The [View] on which the touch events will be handled.
 * @param listener The [OnForceClickListener] instance that will receive the click events, or null if no listener is set.
 * @param threshold The force touch pressure threshold value (in the range 0.0 to 1.0) to distinguish between a force click and a normal click.
 */
class ClickListenerImpl(
    view: View,
    listener: OnForceClickListener?,
    threshold: Float
) : OnTouchListener {

    private val gestureDetector =
        GestureDetector(view.context, object : GestureDetector.SimpleOnGestureListener() {

            override fun onSingleTapConfirmed(event: MotionEvent): Boolean {
                if (!ForceGesturesInformer.readyForUse)
                    listener?.onUndefinedClick(view)
                else if (PressureHelper.isForceTouch(event, threshold))
                    listener?.onForceClick(view)
                else
                    listener?.onNormalClick(view)
                return super.onSingleTapConfirmed(event)
            }
        })

    override fun onTouch(view: View, event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_UP)
            view.performClick()
        return gestureDetector.onTouchEvent(event)
    }
}