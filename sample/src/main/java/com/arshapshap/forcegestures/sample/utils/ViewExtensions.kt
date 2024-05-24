package com.arshapshap.forcegestures.sample.utils

import android.view.View

internal fun View.setVisible(isVisible: Boolean) {
    this.visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
}