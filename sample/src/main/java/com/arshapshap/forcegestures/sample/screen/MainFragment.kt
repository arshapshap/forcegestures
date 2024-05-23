package com.arshapshap.forcegestures.sample.screen

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.arshapshap.forcegestures.ForceGesturesInformer
import com.arshapshap.forcegestures.sample.R
import com.arshapshap.forcegestures.sample.base.BaseFragment
import com.arshapshap.forcegestures.sample.databinding.FragmentMainBinding
import com.arshapshap.forcegestures.sample.utils.setVisible

internal class MainFragment : BaseFragment<FragmentMainBinding>(
    FragmentMainBinding::inflate
) {

    override fun initViews() = with(binding) {
        if (!ForceGesturesInformer.doesDeviceSupportForceTouches)
            warningTextView.text = getString(R.string.your_device_does_not_support_force_touches)
        else if (ForceGesturesInformer.doesDeviceSupportForceTouches)
            warningTextView.text = getString(R.string.calibration_is_required)
        warningTextView.setVisible(!ForceGesturesInformer.readyToUse)
        configureToolbar()
        setOnClickListeners()
        setButtonsNames()
    }

    private fun setOnClickListeners() = with(binding) {
        forceTouchFragmentButton.onClickNavigateTo(R.id.forceTouchFragment)
        longForceTouchFragmentButton.onClickNavigateTo(R.id.longForceTouchFragment)
        doubleForceTouchFragmentButton.onClickNavigateTo(R.id.doubleForceTouchFragment)
        forcePressFragmentButton.onClickNavigateTo(R.id.forcePressFragment)
        forceSwipeFragmentButton.onClickNavigateTo(R.id.forceSwipeFragment)
        forceScrollFragmentButton.onClickNavigateTo(R.id.forceVerticalScrollFragment)
        forcePinchFragmentButton.onClickNavigateTo(R.id.forceScaleFragment)
    }

    private fun setButtonsNames() = with(binding) {
        forceTouchFragmentButton.text = getButtonName(R.string.force_click)
        longForceTouchFragmentButton.text = getButtonName(R.string.long_force_click)
        doubleForceTouchFragmentButton.text = getButtonName(R.string.double_force_click)
        forcePressFragmentButton.text = getButtonName(R.string.force_press)
        forceSwipeFragmentButton.text = getButtonName(R.string.force_swipe)
        forceScrollFragmentButton.text = getButtonName(R.string.force_scroll)
        forcePinchFragmentButton.text = getButtonName(R.string.force_scale)
    }

    private fun configureToolbar() {
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_main_toolbar, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.action_calibration -> {
                        findNavController().navigate(R.id.calibrationFragment)
                        true
                    }

                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun Button.onClickNavigateTo(@IdRes destination: Int) = setOnClickListener {
        findNavController().navigate(destination)
    }

    private fun getButtonName(@StringRes gestureStringId: Int): String {
        return getString(R.string.test, getString(gestureStringId))
    }
}