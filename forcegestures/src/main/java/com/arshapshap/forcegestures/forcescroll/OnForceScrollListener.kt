package com.arshapshap.forcegestures.forcescroll

import android.view.View

fun interface OnForceScrollListener {

    /**
     * Called while scrolling view.
     *
     * @param view The view that was scrolled.
     * @param velocity The value indicating the speed of scrolling.
     */
    fun onForceScroll(view: View, velocity: Float)
}
