package com.arshapshap.forcegestures.longforceclick

import android.view.View

/**
 * Listener interface for receiving long force click and long normal click events on a [View].
 *
 * This interface should be implemented by classes that need to handle long force click and long normal click
 * events on a [View]. The [onLongForceClick] method will be called when a long force click (a long click with
 * increased pressure) is detected, and the [onLongNormalClick] method will be called for a regular
 * long click.
 *
 * To set an instance of this listener on a [View], use the [View.setOnLongForceClickListener] extension
 * function.
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
}