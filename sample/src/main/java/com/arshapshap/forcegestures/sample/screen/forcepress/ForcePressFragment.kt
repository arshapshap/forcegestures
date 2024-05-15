package com.arshapshap.forcegestures.sample.screen.forcepress

import android.view.View
import com.arshapshap.forcegestures.forcepress.OnForcePressListener
import com.arshapshap.forcegestures.forcepress.setOnForcePressListener
import com.arshapshap.forcegestures.sample.R
import com.arshapshap.forcegestures.sample.base.BaseGestureTestFragment

class ForcePressFragment : BaseGestureTestFragment(), OnForcePressListener {

    override fun initViews() = with(binding) {
        super.initViews(R.string.force_press)
        cardView.setOnForcePressListener(this@ForcePressFragment)
    }

    override fun onForcePress(view: View, pressure: Float) = with(binding.resultTextView) {
        text = context.getString(R.string.pressure, pressure)
        this.clearAfterDelay()
    }
}