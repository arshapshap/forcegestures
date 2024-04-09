package com.arshapshap.forcegestures.forceclick

import android.view.View

interface OnForceClickListener {

    /**
     * Called after short force click on view.
     *
     * @param view The view that was clicked.
     */
    fun onForceClick(view: View)

    /**
     * Called after short normal click on view.
     *
     * @param view The view that was clicked.
     */
    fun onNormalClick(view: View)
}
