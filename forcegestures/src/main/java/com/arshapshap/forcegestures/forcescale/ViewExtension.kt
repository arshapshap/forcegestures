package com.arshapshap.forcegestures.forcescale

import android.view.View

/**
 * Sets an [OnForceScaleListener] on this [View] to receive continuous force scale events.
 *
 * @receiver The [View] on which the listener will be set.
 * @param listener The [OnForceScaleListener] instance to receive force scale events, or null to clear the existing listener.
 *
 * @see OnForceScaleListener
 */
fun View.setOnForceScaleListener(listener: OnForceScaleListener?) {
    setOnTouchListener(ScaleListenerImpl(this, listener))
}