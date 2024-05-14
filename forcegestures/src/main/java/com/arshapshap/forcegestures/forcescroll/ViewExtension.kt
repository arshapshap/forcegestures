package com.arshapshap.forcegestures.forcescroll

import android.view.View
import androidx.recyclerview.widget.RecyclerView

fun View.setOnForceScrollListener(listener: OnForceScrollListener) {
    setOnTouchListener(OnTouchListenerImpl { listener.onForceScroll(this, it) })
}

fun RecyclerView.setForceScrollListener() {
    setOnTouchListener(OnTouchListenerImpl { this.scrollBy(0, it.toInt()) })
}