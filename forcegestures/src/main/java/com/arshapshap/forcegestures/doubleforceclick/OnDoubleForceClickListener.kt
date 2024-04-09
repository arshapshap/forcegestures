package com.arshapshap.forcegestures.doubleforceclick

import android.view.View

interface OnDoubleForceClickListener {

    /**
     * Called when after double force click on view.
     *
     * @param view The view that was double clicked.
     */
    fun onDoubleForceClick(view: View)

    /**
     * Called when after double normal click on view.
     *
     * @param view The view that was double clicked.
     */
    fun onDoubleNormalClick(view: View)
}
