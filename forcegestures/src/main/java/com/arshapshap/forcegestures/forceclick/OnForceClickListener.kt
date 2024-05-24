package com.arshapshap.forcegestures.forceclick

import android.view.View

/**
 * Listener interface for receiving force click, normal click, and undefined click events on a [View].
 *
 * This interface should be implemented by classes that need to handle force click, normal click,
 * and undefined click events on a [View]. The [onForceClick] method will be called when a force click
 * (a click with increased pressure) is detected, the [onNormalClick] method will be called for a regular
 * click, and the [onUndefinedClick] method will be called for clicks that cannot be classified as
 * force or normal clicks (e.g., on devices that do not support pressure sensitivity).
 *
 * To set an instance of this listener on a [View], use the [View.setOnForceClickListener] extension
 * function.
 */
interface OnForceClickListener {

    /**
     * Called when a force click (a click with increased pressure) is detected on the associated [View].
     *
     * @param view The [View] that received the force click event.
     */
    fun onForceClick(view: View)

    /**
     * Called when a normal click (without increased pressure) is detected on the associated [View].
     *
     * @param view The [View] that received the normal click event.
     */
    fun onNormalClick(view: View)

    /**
     * Called when a click is detected on the associated [View], but it cannot be classified as
     * a force click or a normal click (e.g., on devices that do not support pressure sensitivity).
     *
     * By default, this method calls [onNormalClick], but it can be overridden to provide custom behavior.
     *
     * @param view The [View] that received the undefined click event.
     */
    fun onUndefinedClick(view: View) = onNormalClick(view)
}