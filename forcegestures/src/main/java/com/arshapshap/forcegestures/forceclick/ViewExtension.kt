package com.arshapshap.forcegestures.forceclick

import android.view.View
import com.arshapshap.forcegestures.DEFAULT_FORCE_TOUCH_THRESHOLD

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
    setOnTouchListener(ClickListenerImpl(this, listener, threshold))
}