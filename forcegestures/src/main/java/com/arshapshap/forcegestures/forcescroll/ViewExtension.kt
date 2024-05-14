package com.arshapshap.forcegestures.forcescroll

import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

fun View.setOnForceScrollListener(listener: OnForceScrollListener, orientation: Int = LinearLayout.VERTICAL) {
    setOnTouchListener(OnTouchListenerImpl(orientation) { listener.onForceScroll(this, it) })
}

fun RecyclerView.setForceScrollListener(orientation: Int = LinearLayout.VERTICAL) {
    setOnTouchListener(OnTouchListenerImpl(orientation) {
        if (orientation == LinearLayout.VERTICAL)
            this.scrollBy(0, it.toInt())
        else
            this.scrollBy(it.toInt(), 0)
    })
}