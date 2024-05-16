package com.arshapshap.forcegestures.sample.screen.longforceclick

import android.view.View
import com.arshapshap.forcegestures.longforceclick.OnLongForceClickListener
import com.arshapshap.forcegestures.longforceclick.setOnLongForceClickListener
import com.arshapshap.forcegestures.sample.R
import com.arshapshap.forcegestures.sample.base.BaseGestureTestFragment
import com.arshapshap.forcegestures.sample.utils.getColorControlHighlight
import com.arshapshap.forcegestures.sample.utils.getPrimaryColor
import com.arshapshap.forcegestures.sample.utils.setRippleColor

internal class LongForceClickFragment : BaseGestureTestFragment(), OnLongForceClickListener {

    override fun initViews() = with (binding)  {
        super.initViews(R.string.long_force_click)
        cardView.setOnClickListener {
            it.foreground.setRippleColor(getColorControlHighlight())
        }
        cardView.setOnLongForceClickListener(this@LongForceClickFragment)
    }

    override fun onLongForceClick(view: View) {
        view.foreground.setRippleColor(getPrimaryColor())
        view.isPressed = false
        view.isPressed = true
        showGestureDetected(R.string.long_force_click)
    }

    override fun onLongNormalClick(view: View) {
        view.foreground.setRippleColor(getColorControlHighlight())
        view.isPressed = false
        view.isPressed = true
        showGestureDetected(R.string.long_normal_click)
    }
}