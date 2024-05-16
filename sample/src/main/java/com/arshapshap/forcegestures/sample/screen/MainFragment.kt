package com.arshapshap.forcegestures.sample.screen

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.transition.Visibility
import com.arshapshap.forcegestures.calibration.CalibrationHelper
import com.arshapshap.forcegestures.sample.R
import com.arshapshap.forcegestures.sample.base.BaseFragment
import com.arshapshap.forcegestures.sample.databinding.FragmentMainBinding

internal class MainFragment : BaseFragment<FragmentMainBinding>(
    FragmentMainBinding::inflate
) {

    override fun initViews() = with(binding) {
        calibrationRequiredTextView.setVisible(CalibrationHelper.calibrationRequired)
        setButtonsEnabled(!CalibrationHelper.calibrationRequired)
        configureToolbar()
        setOnClickListeners()
        setButtonsNames()
    }

    private fun setButtonsEnabled(isEnabled: Boolean) = with(binding) {
        forceTouchFragmentButton.isEnabled = isEnabled
        longForceTouchFragmentButton.isEnabled = isEnabled
        doubleForceTouchFragmentButton.isEnabled = isEnabled
        forcePressFragmentButton.isEnabled = isEnabled
        forceSwipeFragmentButton.isEnabled = isEnabled
        forceScrollFragmentButton.isEnabled = isEnabled
        forcePinchFragmentButton.isEnabled = isEnabled
    }

    private fun setOnClickListeners() = with(binding) {
        forceTouchFragmentButton.onClickNavigateTo(R.id.forceTouchFragment)
        longForceTouchFragmentButton.onClickNavigateTo(R.id.longForceTouchFragment)
        doubleForceTouchFragmentButton.onClickNavigateTo(R.id.doubleForceTouchFragment)
        forcePressFragmentButton.onClickNavigateTo(R.id.forcePressFragment)
        forceSwipeFragmentButton.onClickNavigateTo(R.id.forceSwipeFragment)
        forceScrollFragmentButton.onClickNavigateTo(R.id.forceScrollFragment)
        forcePinchFragmentButton.onClickNavigateTo(R.id.forcePinchFragment)
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

    private fun View.setVisible(isVisible: Boolean) {
        this.visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
    }

    private fun Button.onClickNavigateTo(@IdRes destination: Int) = setOnClickListener {
        findNavController().navigate(destination)
    }

    private fun getButtonName(@StringRes gestureStringId: Int): String {
        return getString(R.string.test, getString(gestureStringId))
    }
}