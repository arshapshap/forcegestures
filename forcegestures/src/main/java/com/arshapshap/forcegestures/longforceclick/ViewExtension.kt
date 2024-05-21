package com.arshapshap.forcegestures.longforceclick

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import com.arshapshap.forcegestures.DEFAULT_FORCE_TOUCH_THRESHOLD
import com.arshapshap.forcegestures.PressureHelper

/**
 * Sets an [OnLongForceClickListener] on this [View] to receive long force click and long normal click events.
 *
 * @receiver The [View] on which the listener will be set.
 * @param listener The [OnLongForceClickListener] instance to receive long click events, or null to clear the existing listener.
 * @param threshold The force touch pressure threshold value (in the range 0.0 to 1.0) to distinguish between a long force click and a long normal click. Defaults to [DEFAULT_FORCE_TOUCH_THRESHOLD].
 *
 * @see OnLongForceClickListener
 */
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