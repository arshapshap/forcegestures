package com.arshapshap.forcegestures.longforceclick

import android.view.View

/**
 * Listener interface for receiving long force click, long normal click, and long undefined click events on a [View].
 *
 * This interface should be implemented by classes that need to handle long force click, long normal click,
 * and long undefined click events on a [View]. The [onLongForceClick] method will be called when a long force click
 * (a long click with increased pressure) is detected, the [onLongNormalClick] method will be called for a regular
 * long click, and the [onLongUndefinedClick] method will be called for long clicks that cannot be classified as
 * force or normal clicks (e.g., on devices that do not support pressure sensitivity).
 *
 * To set an instance of this listener on a [View], use the [View.setOnLongForceClickListener] extension function.
 */
interface OnLongForceClickListener {

    /**
     * Called when a long force click (a long click with increased pressure) is detected on the associated [View].
     *
     * @param view The [View] that received the long force click event.
     */
    fun onLongForceClick(view: View)

    /**
     * Called when a long normal click (without increased pressure) is detected on the associated [View].
     *
     * @param view The [View] that received the long normal click event.
     */
    fun onLongNormalClick(view: View)

    /**
     * Called when a long click is detected on the associated [View], but it cannot be classified as
     * a long force click or a long normal click (e.g., on devices that do not support pressure sensitivity).
     *
     * By default, this method calls [onLongNormalClick], but it can be overridden to provide custom behavior.
     *
     * @param view The [View] that received the long undefined click event.
     */
    fun onLongUndefinedClick(view: View) = onLongNormalClick(view)
}