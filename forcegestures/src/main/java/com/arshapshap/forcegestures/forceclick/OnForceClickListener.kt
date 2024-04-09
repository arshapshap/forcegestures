package com.arshapshap.forcegestures.forceclick

import android.view.View

interface OnForceClickListener {

    /**
     * Called when after short force click on view.
     *
     * @param view The view that was clicked.
     */
    fun onForceClick(view: View)

    /**
     * Called when after short normal click on view.
     *
     * @param view The view that was clicked.
     */
    fun onNormalClick(view: View)
}
