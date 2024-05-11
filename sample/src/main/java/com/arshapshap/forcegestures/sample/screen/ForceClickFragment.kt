package com.arshapshap.forcegestures.sample.screen

import android.view.View
import com.arshapshap.forcegestures.forceclick.OnForceClickListener
import com.arshapshap.forcegestures.forceclick.setOnForceClickListener
import com.arshapshap.forcegestures.sample.R
import com.arshapshap.forcegestures.sample.base.BaseGestureTestFragment
import com.arshapshap.forcegestures.sample.utils.getColorControlHighlight
import com.arshapshap.forcegestures.sample.utils.getPrimaryColor
import com.arshapshap.forcegestures.sample.utils.setRippleColor

class ForceClickFragment : BaseGestureTestFragment(), OnForceClickListener {

    override fun initViews() = with (binding)  {
        super.initViews(R.string.force_click)
        cardView.setOnForceClickListener(this@ForceClickFragment)
    }

    override fun onForceClick(view: View) {
        view.foreground.setRippleColor(getPrimaryColor())
        showGestureDetected(R.string.force_click)
    }

    override fun onNormalClick(view: View) {
        view.foreground.setRippleColor(getColorControlHighlight())
        showGestureDetected(R.string.normal_click)
    }
}