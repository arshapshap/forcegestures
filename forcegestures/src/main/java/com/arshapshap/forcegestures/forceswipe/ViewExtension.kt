package com.arshapshap.forcegestures.forceswipe

import android.view.View
import com.arshapshap.forcegestures.DEFAULT_FORCE_TOUCH_THRESHOLD

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
    setOnTouchListener(SwipeListenerImpl(this, listener, threshold))
}