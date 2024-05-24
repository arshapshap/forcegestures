package com.arshapshap.forcegestures.sample.screen.calibration

import android.content.SharedPreferences
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isGone
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import com.arshapshap.forcegestures.ForceGesturesInformer
import com.arshapshap.forcegestures.calibration.CalibrationException
import com.arshapshap.forcegestures.calibration.PressureCalibrator
import com.arshapshap.forcegestures.calibration.listener.setOnRawPressureListener
import com.arshapshap.forcegestures.sample.R
import com.arshapshap.forcegestures.sample.base.BaseFragment
import com.arshapshap.forcegestures.sample.databinding.FragmentCalibrationBinding
import com.arshapshap.forcegestures.sample.utils.firstCap
import com.arshapshap.forcegestures.sample.utils.getColorControlHighlight
import com.arshapshap.forcegestures.sample.utils.setRippleColor
import com.arshapshap.forcegestures.sample.utils.showToast

internal class CalibrationFragment : BaseFragment<FragmentCalibrationBinding>(
    FragmentCalibrationBinding::inflate
) {

    private val viewModel: CalibrationViewModel by lazy {
        ViewModelProvider(this)[CalibrationViewModel::class.java]
    }

    private val sharedPreferences: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(requireContext())
    }

    override fun initViews() = with(binding) {
        cardView.foreground.setRippleColor(getColorControlHighlight())
        setTextViewsText()
        setOnClickListeners()
    }

    override fun subscribe() = with(binding) {
        viewModel.stepAndIndex.observe(this@CalibrationFragment) { (step, index) ->
            if (step == CalibrationStep.Saved) {
                saveValues()
            } else {
                updateAppearance(step, index)
            }
        }
        viewModel.pressure.observe(this@CalibrationFragment) {
            fillGrid(it)
        }
    }

    private fun setTextViewsText() = with(binding) {
        titleTextView.text =
            if (ForceGesturesInformer.calibrationRequired) getString(R.string.calibration_is_required)
            else getString(R.string.calibration_completed)
        pressureTextView.text = pressureTextView.text.toString().firstCap()
        weakTouchTextView.text = weakTouchTextView.text.toString().firstCap()
        forceTouchTextView.text = forceTouchTextView.text.toString().firstCap()
    }

    private fun setOnClickListeners() = with(binding) {
        cardView.setOnRawPressureListener { _, pressure ->
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

    private fun updateAppearance(step: CalibrationStep, index: Int) = with(binding) {
        hintTextView.text = getHintText(step)
        saveButton.isEnabled = step == CalibrationStep.Done
        cardView.isClickable = step != CalibrationStep.Done
        touchImageView.isGone = step == CalibrationStep.Done
        resetLastValueButton.isEnabled = step != CalibrationStep.WeakTouch || index != 0
        resetAllButton.isEnabled = step != CalibrationStep.WeakTouch || index != 0
    }

    private fun fillGrid(it: Array<FloatArray>) {
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

    private fun saveValues() = viewModel.pressure.value?.let {
        try {
            PressureCalibrator.Editor(sharedPreferences).savePressure(
                weakPressure = it[0].average().toFloat(),
                forcePressure = it[1].average().toFloat()
            )
            binding.titleTextView.text = getString(R.string.calibration_completed)
            showToast(getString(R.string.calibration_completed))
            findNavController().popBackStack()
        } catch (e: CalibrationException) {
            showToast(getString(R.string.weak_pressure_cannot_be_greater_than_force_pressure), Toast.LENGTH_LONG)
            viewModel.rollbackSaving()
        }
    }

    private fun getHintText(step: CalibrationStep) = when (step) {
        CalibrationStep.WeakTouch -> getString(R.string.make, getString(R.string.weak_touch))
        CalibrationStep.ForceTouch -> getString(R.string.make, getString(R.string.force_touch))
        else -> getString(R.string.all_touches_are_done)
    }

    private fun getPressureCell(step: CalibrationStep, index: Int): TextView {
        return when {
            step == CalibrationStep.WeakTouch && index == 0 -> binding.weakPressureTextView1
            step == CalibrationStep.WeakTouch && index == 1 -> binding.weakPressureTextView2
            step == CalibrationStep.WeakTouch && index == 2 -> binding.weakPressureTextView3
            step == CalibrationStep.ForceTouch && index == 0 -> binding.forcePressureTextView1
            step == CalibrationStep.ForceTouch && index == 1 -> binding.forcePressureTextView2
            step == CalibrationStep.ForceTouch && index == 2 -> binding.forcePressureTextView3
            else -> throw IllegalArgumentException()
        }
    }
}