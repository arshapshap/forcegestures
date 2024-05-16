package com.arshapshap.forcegestures.calibration

import android.view.View

fun interface OnTouchWithPressureListener {

    /**
     * Called after touch on view.
     *
     * @param view The view that was touched.
     * @param pressure The value indicating the force of pressing.
     */
    fun onTouch(view: View, pressure: Float)
}