package com.arshapshap.forcegestures.longforceclick

import android.view.View

interface OnLongForceClickListener {

    /**
     * Called after long force click on view.
     *
     * @param view The view that was long clicked.
     */
    fun onLongForceClick(view: View)

    /**
     * Called after long normal click on view.
     *
     * @param view The view that was long clicked.
     */
    fun onLongNormalClick(view: View)
}
