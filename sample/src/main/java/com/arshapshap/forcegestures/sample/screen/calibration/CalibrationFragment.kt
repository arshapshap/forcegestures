package com.arshapshap.forcegestures.sample.screen.calibration

import android.widget.TextView
import androidx.core.view.isGone
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.arshapshap.forcegestures.calibration.CalibrationHelper
import com.arshapshap.forcegestures.calibration.setOnTouchWithPressureListener
import com.arshapshap.forcegestures.sample.R
import com.arshapshap.forcegestures.sample.base.BaseFragment
import com.arshapshap.forcegestures.sample.databinding.FragmentCalibrationBinding
import com.arshapshap.forcegestures.sample.utils.firstCap
import com.arshapshap.forcegestures.sample.utils.showToast

internal class CalibrationFragment : BaseFragment<FragmentCalibrationBinding>(
    FragmentCalibrationBinding::inflate
) {

    private val viewModel by lazy {
        ViewModelProvider(this)[CalibrationViewModel::class.java]
    }

    override fun initViews() = with(binding) {
        titleTextView.text =
            if (CalibrationHelper.calibrationRequired) getString(R.string.calibration_is_required)
            else getString(R.string.calibration_completed)
        pressureTextView.text = pressureTextView.text.toString().firstCap()
        weakTouchTextView.text = weakTouchTextView.text.toString().firstCap()
        normalTouchTextView.text = normalTouchTextView.text.toString().firstCap()
        forceTouchTextView.text = forceTouchTextView.text.toString().firstCap()

        cardView.setOnTouchWithPressureListener { _, pressure ->
            viewModel.addPressureValue(pressure)
        }
        saveButton.setOnClickListener {
            viewModel.save()
        }
        resetLastValueButton.setOnClickListener {
            viewModel.resetLastValue()
        }
        resetAllButton.setOnClickListener {
            viewModel.resetAll()
        }
    }

    override fun subscribe() = with(binding) {
        viewModel.stepAndIndex.observe(this@CalibrationFragment) { (step, index) ->
            if (step == CalibrationStep.Saved) {
                showToast(getString(R.string.calibration_completed))
                titleTextView.text = getString(R.string.calibration_completed)
                findNavController().popBackStack()
            } else {
                hintTextView.text = getHintText(step)
                saveButton.isEnabled = step == CalibrationStep.Done
                cardView.isClickable = step != CalibrationStep.Done
                touchImageView.isGone = step == CalibrationStep.Done
                resetLastValueButton.isEnabled = step != CalibrationStep.WeakTouch || index != 0
                resetAllButton.isEnabled = step != CalibrationStep.WeakTouch || index != 0
            }
        }
        viewModel.pressure.observe(this@CalibrationFragment) {
            for ((step, values) in it.withIndex()) {
                for ((index, value) in values.withIndex()) {
                    if (value != 0f)
                        getPressureCell(CalibrationStep.entries[step], index).text =
                            getString(R.string.float_value, value)
                    else
                        getPressureCell(CalibrationStep.entries[step], index).text =
                            getString(R.string.empty_float_value)
                }
            }
        }
    }

    private fun getHintText(step: CalibrationStep) = when (step) {
        CalibrationStep.WeakTouch -> getString(R.string.make, getString(R.string.weak_touch))
        CalibrationStep.NormalTouch -> getString(R.string.make, getString(R.string.normal_touch))
        CalibrationStep.ForceTouch -> getString(R.string.make, getString(R.string.force_touch))
        else -> getString(R.string.all_touches_are_done)
    }

    private fun getPressureCell(step: CalibrationStep, index: Int): TextView {
        return when {
            step == CalibrationStep.WeakTouch && index == 0 -> binding.weakPressureTextView1
            step == CalibrationStep.WeakTouch && index == 1 -> binding.weakPressureTextView2
            step == CalibrationStep.WeakTouch && index == 2 -> binding.weakPressureTextView3
            step == CalibrationStep.NormalTouch && index == 0 -> binding.normalPressureTextView1
            step == CalibrationStep.NormalTouch && index == 1 -> binding.normalPressureTextView2
            step == CalibrationStep.NormalTouch && index == 2 -> binding.normalPressureTextView3
            step == CalibrationStep.ForceTouch && index == 0 -> binding.forcePressureTextView1
            step == CalibrationStep.ForceTouch && index == 1 -> binding.forcePressureTextView2
            step == CalibrationStep.ForceTouch && index == 2 -> binding.forcePressureTextView3
            else -> throw IllegalArgumentException()
        }
    }
}