package com.arshapshap.forcegestures.doubleforceclick

import android.view.View

/**
 * Listener interface for receiving double force click, double normal click, and double undefined click events on a [View].
 *
 * This interface should be implemented by classes that need to handle double force click, double normal click,
 * and double undefined click events on a [View]. The [onDoubleForceClick] method will be called when a double force click
 * (two quick force clicks) is detected, the [onDoubleNormalClick] method will be called for a regular double click,
 * and the [onDoubleUndefinedClick] method will be called for double clicks that cannot be classified as force or normal
 * clicks (e.g., on devices that do not support pressure sensitivity).
 *
 * To set an instance of this listener on a [View], use the [View.setOnDoubleForceClickListener] extension function.
 */
interface OnDoubleForceClickListener {

    /**
     * Called when a double force click (two quick force clicks) is detected on the associated [View].
     *
     * @param view The [View] that received the double force click event.
     */
    fun onDoubleForceClick(view: View)

    /**
     * Called when a double normal click (without increased pressure) is detected on the associated [View].
     *
     * @param view The [View] that received the double normal click event.
     */
    fun onDoubleNormalClick(view: View)

    /**
     * Called when a double click is detected on the associated [View], but it cannot be classified as
     * a double force click or a double normal click (e.g., on devices that do not support pressure sensitivity).
     *
     * By default, this method calls [onDoubleNormalClick], but it can be overridden to provide custom behavior.
     *
     * @param view The [View] that received the double undefined click event.
     */
    fun onDoubleUndefinedClick(view: View) = onDoubleNormalClick(view)
}