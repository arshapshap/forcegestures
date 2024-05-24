package com.arshapshap.forcegestures.forcescroll

import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Sets an [OnForceScrollListener] on this [View] to receive continuous force scroll events.
 *
 * @receiver The [View] on which the listener will be set.
 * @param listener The [OnForceScrollListener] instance to receive force scroll events, or null to clear the existing listener.
 *
 * @see OnForceScrollListener
 */
fun View.setOnForceScrollListener(listener: OnForceScrollListener?) {
    setOnTouchListener(ScrollListenerImpl(listener))
}

/**
 * Sets an [OnForceScrollListener] on this [RecyclerView] to automatically scroll the RecyclerView based
 * on the force scroll gesture.
 *
 * @receiver The [RecyclerView] on which the listener will be set.
 * @param orientation The orientation of the scroll gesture. Defaults to the orientation of the RecyclerView's [LinearLayoutManager], but needs to be explicitly provided if the LayoutManager is not a subclass of [LinearLayoutManager].
 */
fun RecyclerView.setForceScrollListener(
    orientation: Int = (this.layoutManager as LinearLayoutManager).orientation
) {
    setOnForceScrollListener { _, velocityX, velocityY ->
        if (orientation == LinearLayout.VERTICAL)
            this.scrollBy(0, velocityY.toInt())
        else
            this.scrollBy(velocityX.toInt(), 0)
    }
}