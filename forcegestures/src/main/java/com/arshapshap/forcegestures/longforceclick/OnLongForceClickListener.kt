package com.arshapshap.forcegestures.longforceclick

import android.view.View

interface OnLongForceClickListener {

    /**
     * Called when after long force click on view.
     *
     * @param view The view that was clicked.
     */
    fun onLongForceClick(view: View)

    /**
     * Called when after long normal click on view.
     *
     * @param view The view that was clicked.
     */
    fun onLongNormalClick(view: View)
}
