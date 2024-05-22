package com.arshapshap.forcegestures.sample.screen.doubleforceclick

import android.view.View
import com.arshapshap.forcegestures.doubleforceclick.OnDoubleForceClickListener
import com.arshapshap.forcegestures.doubleforceclick.setOnDoubleForceClickListener
import com.arshapshap.forcegestures.sample.R
import com.arshapshap.forcegestures.sample.base.BaseGestureTestFragment
import com.arshapshap.forcegestures.sample.utils.getColorControlHighlight
import com.arshapshap.forcegestures.sample.utils.getPrimaryColor
import com.arshapshap.forcegestures.sample.utils.setRippleColor

internal class DoubleForceClickFragment : BaseGestureTestFragment(), OnDoubleForceClickListener {

    override fun initViews() = with(binding) {
        super.initViews(R.string.double_force_click)
        cardView.setOnClickListener {
            it.foreground.setRippleColor(getColorControlHighlight())
        }
        cardView.setOnDoubleForceClickListener(this@DoubleForceClickFragment)
    }

    override fun onDoubleForceClick(view: View) {
        view.foreground.setRippleColor(getPrimaryColor())
        view.isPressed = false
        view.isPressed = true
        showGestureDetected(R.string.double_force_click)
    }

    override fun onDoubleNormalClick(view: View) {
        showGestureDetected(R.string.double_normal_click)
    }
}