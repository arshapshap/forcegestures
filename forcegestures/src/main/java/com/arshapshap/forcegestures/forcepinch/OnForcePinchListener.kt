package com.arshapshap.forcegestures.forcepinch

import android.view.View

interface OnForcePinchListener {

    /**
     * Called while pinching view.
     *
     * @param view The view that was pinched.
     * @param velocity The value indicating the speed of zooming.
     */
    fun onForcePinch(view: View, velocity: Float)
}
