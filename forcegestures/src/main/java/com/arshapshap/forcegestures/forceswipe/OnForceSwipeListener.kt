package com.arshapshap.forcegestures.forceswipe

import android.view.View

/**
 * Listener interface for receiving force swipe, normal swipe, and undefined swipe events on a [View].
 *
 * This interface should be implemented by classes that need to handle force swipe, normal swipe,
 * and undefined swipe events on a [View]. The [onForceSwipe] method will be called when a force swipe
 * (a swipe gesture with increased pressure) is detected, the [onNormalSwipe] method will be called
 * for a regular swipe gesture, and the [onUndefinedSwipe] method will be called for swipe gestures
 * that cannot be classified as force or normal swipes (e.g., on devices that do not support pressure sensitivity).
 *
 * To set an instance of this listener on a [View], use the [View.setOnForceSwipeListener] extension function.
 */
interface OnForceSwipeListener {

    /**
     * Called when a force swipe (a swipe gesture with increased pressure) is detected on the associated [View].
     *
     * @param view The [View] that received the force swipe event.
     * @param velocityX The horizontal velocity of the swipe gesture in pixels per second.
     * @param velocityY The vertical velocity of the swipe gesture in pixels per second.
     */
    fun onForceSwipe(view: View, velocityX: Float, velocityY: Float)

    /**
     * Called when a normal swipe (without increased pressure) is detected on the associated [View].
     *
     * @param view The [View] that received the normal swipe event.
     * @param velocityX The horizontal velocity of the swipe gesture in pixels per second.
     * @param velocityY The vertical velocity of the swipe gesture in pixels per second.
     */
    fun onNormalSwipe(view: View, velocityX: Float, velocityY: Float)

    /**
     * Called when a swipe gesture is detected on the associated [View], but it cannot be classified as
     * a force swipe or a normal swipe (e.g., on devices that do not support pressure sensitivity).
     *
     * By default, this method calls [onNormalSwipe], but it can be overridden to provide custom behavior.
     *
     * @param view The [View] that received the undefined swipe event.
     * @param velocityX The horizontal velocity of the swipe gesture in pixels per second.
     * @param velocityY The vertical velocity of the swipe gesture in pixels per second.
     */
    fun onUndefinedSwipe(view: View, velocityX: Float, velocityY: Float) = onNormalSwipe(view, velocityX, velocityY)
}