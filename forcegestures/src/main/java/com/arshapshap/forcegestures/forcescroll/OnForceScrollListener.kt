package com.arshapshap.forcegestures.forcescroll

import android.view.View

interface OnForceScrollListener {

    /**
     * Called while scrolling view.
     *
     * @param view The view that was scrolled.
     * @param delta The value indicating the speed of scrolling.
     */
    fun onForceScroll(view: View, delta: Float)
}
