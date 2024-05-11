package com.arshapshap.forcegestures.forceswipe

import android.view.View

interface OnForceSwipeListener {

    /**
     * Called after force swipe on view.
     *
     * @param view The view that was swiped.
     */
    fun onForceSwipe(view: View)

    /**
     * Called after normal swipe on view.
     *
     * @param view The view that was swiped.
     */
    fun onNormalSwipe(view: View)
}
