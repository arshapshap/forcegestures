package com.arshapshap.forcegestures.forcepress

import android.view.View

/**
 * Sets an [OnForcePressListener] on this [View] to receive continuous force press events.
 *
 * @receiver The [View] on which the listener will be set.
 * @param listener The [OnForcePressListener] instance to receive force press events, or null to clear the existing listener.
 *
 * @see OnForcePressListener
 */
fun View.setOnForcePressListener(listener: OnForcePressListener?) {
    setOnTouchListener(PressListenerImpl(listener))
}