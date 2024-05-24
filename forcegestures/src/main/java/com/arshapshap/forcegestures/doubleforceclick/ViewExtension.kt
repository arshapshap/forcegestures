package com.arshapshap.forcegestures.doubleforceclick

import android.view.View
import com.arshapshap.forcegestures.DEFAULT_FORCE_TOUCH_THRESHOLD

/**
 * Sets an [OnDoubleForceClickListener] on this [View] to receive double force click and double normal click events.
 *
 * @receiver The [View] on which the listener will be set.
 * @param listener The [OnDoubleForceClickListener] instance to receive double click events, or null to clear the existing listener.
 * @param threshold The force touch pressure threshold value (in the range 0.0 to 1.0) to distinguish between a double force click and a double normal click. Defaults to [DEFAULT_FORCE_TOUCH_THRESHOLD].
 *
 * @see OnDoubleForceClickListener
 */
fun View.setOnDoubleForceClickListener(
    listener: OnDoubleForceClickListener?,
    threshold: Float = DEFAULT_FORCE_TOUCH_THRESHOLD
) {
    setOnTouchListener(DoubleClickListenerImpl(this, listener, threshold))
}