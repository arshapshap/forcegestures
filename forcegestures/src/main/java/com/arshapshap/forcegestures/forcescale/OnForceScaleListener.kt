package com.arshapshap.forcegestures.forcescale

import android.view.View

fun interface OnForceScaleListener {

    /**
     * Called while scaling view.
     *
     * @param view The view that was scaled.
     * @param scaleFactor The value indicating the factor of scale.
     */
    fun onForceScale(view: View, scaleFactor: Float)
}
