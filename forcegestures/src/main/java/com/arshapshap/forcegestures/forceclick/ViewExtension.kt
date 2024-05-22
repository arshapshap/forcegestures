package com.arshapshap.forcegestures.forceclick

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import com.arshapshap.forcegestures.DEFAULT_FORCE_TOUCH_THRESHOLD
import com.arshapshap.forcegestures.ForceGesturesInformer
import com.arshapshap.forcegestures.PressureHelper

/**
 * Sets an [OnForceClickListener] on this [View] to receive force click and normal click events.
 *
 * @receiver The [View] on which the listener will be set.
 * @param listener The [OnForceClickListener] instance to receive click events, or null to clear the existing listener.
 * @param threshold The force touch pressure threshold value (in the range 0.0 to 1.0) to distinguish between a force click and a normal click. Defaults to [DEFAULT_FORCE_TOUCH_THRESHOLD].
 *
 * @see OnForceClickListener
 */
fun View.setOnForceClickListener(
    listener: OnForceClickListener?,
    threshold: Float = DEFAULT_FORCE_TOUCH_THRESHOLD
) {
    val view = this
    val gestureDetector =
        GestureDetector(this.context, object : GestureDetector.SimpleOnGestureListener() {

            override fun onSingleTapConfirmed(event: MotionEvent): Boolean {
                if (!ForceGesturesInformer.readyToUse)
                    listener?.onUndefinedClick(view)
                else if (PressureHelper.isForceTouch(event, threshold))
                    listener?.onForceClick(view)
                else
                    listener?.onNormalClick(view)
                return super.onSingleTapConfirmed(event)
            }
        })
    setOnTouchListener { _, event ->
        if (event.action == MotionEvent.ACTION_UP)
            performClick()
        gestureDetector.onTouchEvent(event)
    }
}