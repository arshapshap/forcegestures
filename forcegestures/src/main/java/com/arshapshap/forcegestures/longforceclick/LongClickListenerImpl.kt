package com.arshapshap.forcegestures.longforceclick

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import com.arshapshap.forcegestures.ForceGesturesInformer
import com.arshapshap.forcegestures.PressureHelper

/**
 * An implementation of the [View.OnTouchListener] interface that handles long click events on a [View].
 * This class is used internally by the [View.setOnLongForceClickListener] extension function to set up the appropriate touch listeners
 * and dispatch events to the provided [OnLongForceClickListener].
 *
 * @param view The [View] on which the touch events will be handled.
 * @param listener The [OnLongForceClickListener] instance that will receive the long click events, or null if no listener is set.
 * @param threshold The force touch pressure threshold value (in the range 0.0 to 1.0) to distinguish between a long force click and a long normal click.
 */
class LongClickListenerImpl(
    view: View,
    listener: OnLongForceClickListener?,
    threshold: Float
) : OnTouchListener {

    private val gestureDetector =
        GestureDetector(view.context, object : GestureDetector.SimpleOnGestureListener() {

            override fun onLongPress(event: MotionEvent) {
                if (!ForceGesturesInformer.readyForUse)
                    listener?.onLongUndefinedClick(view)
                else if (PressureHelper.isForceTouch(event, threshold))
                    listener?.onLongForceClick(view)
                else
                    listener?.onLongNormalClick(view)
            }
        })

    override fun onTouch(view: View, event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_UP)
            view.performClick()
        return gestureDetector.onTouchEvent(event)
    }
}