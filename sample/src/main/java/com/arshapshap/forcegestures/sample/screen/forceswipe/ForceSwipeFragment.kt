package com.arshapshap.forcegestures.sample.screen.forceswipe

import android.view.View
import com.arshapshap.forcegestures.forceswipe.OnForceSwipeListener
import com.arshapshap.forcegestures.forceswipe.setOnForceSwipeListener
import com.arshapshap.forcegestures.sample.R
import com.arshapshap.forcegestures.sample.base.BaseGestureTestFragment
import com.arshapshap.forcegestures.sample.utils.getColorControlHighlight
import com.arshapshap.forcegestures.sample.utils.getPrimaryColor
import com.arshapshap.forcegestures.sample.utils.setRippleColor

class ForceSwipeFragment : BaseGestureTestFragment(), OnForceSwipeListener {

    override fun initViews() = with (binding) {
        super.initViews(R.string.force_swipe)
        cardView.setOnClickListener {
            it.foreground.setRippleColor(getColorControlHighlight())
        }
        cardView.setOnForceSwipeListener(this@ForceSwipeFragment)
    }

    override fun onForceSwipe(view: View) {
        view.foreground.setRippleColor(getPrimaryColor())
        view.isPressed = false
        view.isPressed = true
        showGestureDetected(R.string.force_swipe)
    }

    override fun onNormalSwipe(view: View) {
        view.foreground.setRippleColor(getColorControlHighlight())
        view.isPressed = false
        view.isPressed = true
        showGestureDetected(R.string.normal_swipe)
    }
}