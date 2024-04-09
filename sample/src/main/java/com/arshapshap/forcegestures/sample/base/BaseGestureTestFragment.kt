package com.arshapshap.forcegestures.sample.base

import androidx.annotation.StringRes
import com.arshapshap.forcegestures.sample.R
import com.arshapshap.forcegestures.sample.databinding.FragmentForceGestureBinding
import com.arshapshap.forcegestures.sample.utils.getColorControlHighlight
import com.arshapshap.forcegestures.sample.utils.setRippleColor

abstract class BaseGestureTestFragment : BaseFragment<FragmentForceGestureBinding>(
    FragmentForceGestureBinding::inflate
) {

    private val clearDetectedGestureRunnable = Runnable { binding.resultTextView.text = "" }

    fun initViews(@StringRes gestureStringId: Int) = with (binding) {
        hintTextView.text = getString(R.string.make, getString(gestureStringId))
        cardView.foreground.setRippleColor(getColorControlHighlight())
    }

    protected fun showGestureDetected(@StringRes gestureStringId: Int) = with(binding.resultTextView) {
        text = getString(R.string.gesture_detected, getString(gestureStringId)).capitalize()
        removeCallbacks(clearDetectedGestureRunnable)
        postDelayed(clearDetectedGestureRunnable, 1500)
    }
}