package com.arshapshap.forcegestures.sample.screen

import com.arshapshap.forcegestures.forcescale.setOnForceScaleListener
import com.arshapshap.forcegestures.sample.R
import com.arshapshap.forcegestures.sample.base.BaseFragment
import com.arshapshap.forcegestures.sample.databinding.FragmentForceScaleBinding

class ForceScaleFragment : BaseFragment<FragmentForceScaleBinding>(
    FragmentForceScaleBinding::inflate
) {

    override fun initViews() = with(binding) {
        hintTextView.text = getString(R.string.make, getString(R.string.force_scale))
        resultTextView.text = getString(R.string.current_scale, 1f)
        cardView.setOnForceScaleListener { _, scaleFactor ->
            val newScale = (scalableImageView.scaleX * scaleFactor).coerceIn(0.05f, 20f)
            scalableImageView.scaleX = newScale
            scalableImageView.scaleY = newScale

            resultTextView.text = getString(R.string.current_scale, newScale)
        }
    }
}