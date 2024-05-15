package com.arshapshap.forcegestures.sample.screen

import android.widget.Button
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.navigation.fragment.findNavController
import com.arshapshap.forcegestures.sample.R
import com.arshapshap.forcegestures.sample.base.BaseFragment
import com.arshapshap.forcegestures.sample.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>(
    FragmentMainBinding::inflate
) {

    override fun initViews() = with (binding) {
        forceTouchFragmentButton.onClickNavigateTo(R.id.forceTouchFragment)
        longForceTouchFragmentButton.onClickNavigateTo(R.id.longForceTouchFragment)
        doubleForceTouchFragmentButton.onClickNavigateTo(R.id.doubleForceTouchFragment)
        forcePressFragmentButton.onClickNavigateTo(R.id.forcePressFragment)
        forceSwipeFragmentButton.onClickNavigateTo(R.id.forceSwipeFragment)
        forceScrollFragmentButton.onClickNavigateTo(R.id.forceScrollFragment)
        forcePinchFragmentButton.onClickNavigateTo(R.id.forcePinchFragment)

        forceTouchFragmentButton.text = getButtonName(R.string.force_click)
        longForceTouchFragmentButton.text = getButtonName(R.string.long_force_click)
        doubleForceTouchFragmentButton.text = getButtonName(R.string.double_force_click)
        forcePressFragmentButton.text = getButtonName(R.string.force_press)
        forceSwipeFragmentButton.text = getButtonName(R.string.force_swipe)
        forceScrollFragmentButton.text = getButtonName(R.string.force_scroll)
        forcePinchFragmentButton.text = getButtonName(R.string.force_scale)
    }

    private fun Button.onClickNavigateTo(@IdRes destination: Int) = setOnClickListener {
        findNavController().navigate(destination)
    }

    private fun getButtonName(@StringRes gestureStringId: Int): String {
        return getString(R.string.test, getString(gestureStringId))
    }
}