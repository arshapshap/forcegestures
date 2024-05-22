package com.arshapshap.forcegestures.doubleforceclick

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import com.arshapshap.forcegestures.ForceGesturesInformer
import com.arshapshap.forcegestures.PressureHelper

/**
 * An implementation of the [View.OnTouchListener] interface that handles double force click and double normal click events on a [View].
 * This class is used internally by the [View.setOnDoubleForceClickListener] extension function to set up the appropriate touch listeners
 * and dispatch events to the provided [OnDoubleForceClickListener].
 *
 * @param view The [View] on which the touch events will be handled.
 * @param listener The [OnDoubleForceClickListener] instance that will receive the double click events, or null if no listener is set.
 * @param threshold The force touch pressure threshold value (in the range 0.0 to 1.0) to distinguish between a double force click and a double normal click.
 */
class DoubleClickListenerImpl(
    view: View,
    listener: OnDoubleForceClickListener?,
    threshold: Float
) : OnTouchListener {

    private val gestureDetector =
        GestureDetector(view.context, object : GestureDetector.SimpleOnGestureListener() {

            override fun onDoubleTap(event: MotionEvent): Boolean {
                if (!ForceGesturesInformer.readyToUse)
                    listener?.onDoubleUndefinedClick(view)
                else if (PressureHelper.isForceTouch(event, threshold))
                    listener?.onDoubleForceClick(view)
                else
                    listener?.onDoubleNormalClick(view)
                return super.onDoubleTap(event)
            }
        })

    override fun onTouch(view: View, event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_UP)
            view.performClick()
        return gestureDetector.onTouchEvent(event)
    }
}