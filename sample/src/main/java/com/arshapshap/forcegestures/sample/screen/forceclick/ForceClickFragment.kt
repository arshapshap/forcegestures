package com.arshapshap.forcegestures.sample.screen.forceclick

import android.view.View
import com.arshapshap.forcegestures.forceclick.OnForceClickListener
import com.arshapshap.forcegestures.forceclick.setOnForceClickListener
import com.arshapshap.forcegestures.sample.R
import com.arshapshap.forcegestures.sample.base.BaseGestureTestFragment
import com.arshapshap.forcegestures.sample.utils.getColorControlHighlight
import com.arshapshap.forcegestures.sample.utils.getPrimaryColor
import com.arshapshap.forcegestures.sample.utils.setRippleColor

internal class ForceClickFragment : BaseGestureTestFragment(), OnForceClickListener {

    override fun initViews() = with (binding)  {
        super.initViews(R.string.force_click)
        cardView.foreground.setRippleColor(getColorControlHighlight())
        cardView.setOnForceClickListener(this@ForceClickFragment)
    }

    override fun onForceClick(view: View) {
        view.foreground.setRippleColor(getPrimaryColor())
        view.isPressed = true
        view.isPressed = false
        showGestureDetected(R.string.force_click)
        view.foreground.setRippleColorAfterDelay(getColorControlHighlight())
    }

    override fun onNormalClick(view: View) {
        showGestureDetected(R.string.normal_click)
    }
}