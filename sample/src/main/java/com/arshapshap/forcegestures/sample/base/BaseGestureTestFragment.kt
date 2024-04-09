package com.arshapshap.forcegestures.sample.base

import android.widget.TextView
import androidx.annotation.StringRes
import androidx.lifecycle.lifecycleScope
import com.arshapshap.forcegestures.sample.R
import com.arshapshap.forcegestures.sample.databinding.FragmentForceGestureBinding
import com.arshapshap.forcegestures.sample.utils.getColorControlHighlight
import com.arshapshap.forcegestures.sample.utils.setRippleColor
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

abstract class BaseGestureTestFragment : BaseFragment<FragmentForceGestureBinding>(
    FragmentForceGestureBinding::inflate
) {

    private var clearResultJob: Job? = null

    fun initViews(@StringRes gestureStringId: Int) = with (binding) {
        hintTextView.text = getString(R.string.make, getString(gestureStringId))
        cardView.foreground.setRippleColor(getColorControlHighlight())
    }

    protected fun showGestureDetected(@StringRes gestureStringId: Int) = with(binding.resultTextView) {
        text = getString(R.string.gesture_detected, getString(gestureStringId)).replaceFirstChar { it.uppercaseChar() }
        this.clearAfterDelay()
    }

    protected fun TextView.clearAfterDelay() {
        clearResultJob?.cancel()
        clearResultJob = lifecycleScope.launch {
            delay(1500)
            text = ""
        }
    }
}