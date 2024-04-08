package com.arshapshap.forcegestures.sample.screen

import android.widget.Button
import androidx.annotation.IdRes
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
    }

    private fun Button.onClickNavigateTo(@IdRes destination: Int) = setOnClickListener {
        findNavController().navigate(destination)
    }
}