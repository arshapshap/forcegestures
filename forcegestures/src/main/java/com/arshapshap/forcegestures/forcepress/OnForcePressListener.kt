package com.arshapshap.forcegestures.forcepress

import android.view.View

interface OnForcePressListener {

    /**
     * Called after long force click on view.
     *
     * @param view The view that was pressed.
     * @param pressure The value indicating the force of pressing.
     */
    fun onForcePress(view: View, pressure: Float)
}
