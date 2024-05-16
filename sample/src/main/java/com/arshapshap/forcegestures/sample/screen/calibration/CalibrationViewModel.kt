package com.arshapshap.forcegestures.sample.screen.calibration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arshapshap.forcegestures.calibration.CalibrationHelper

internal enum class CalibrationStep {
    WeakTouch,
    NormalTouch,
    ForceTouch,
    Done,
    Saved
}

internal class CalibrationViewModel : ViewModel() {

    private val _stepAndIndex = MutableLiveData(CalibrationStep.WeakTouch to 0)
    val stepAndIndex: LiveData<Pair<CalibrationStep, Int>> = _stepAndIndex

    private val _pressure = MutableLiveData(Array(3) { FloatArray(3) })
    val pressure: LiveData<Array<FloatArray>> = _pressure

    fun addPressureValue(pressure: Float) {
        if (stepAndIndex.value!!.first == CalibrationStep.Done)
            return
        _pressure.postValue(
            _pressure.value!!.apply {
                this[stepAndIndex.value!!.first.ordinal][stepAndIndex.value!!.second] = pressure
            }
        )
        val newStep = if (stepAndIndex.value!!.second == 2) CalibrationStep.entries[stepAndIndex.value!!.first.ordinal + 1]
                else stepAndIndex.value!!.first
        val newIndex = (stepAndIndex.value!!.second + 1) % 3
        _stepAndIndex.postValue(newStep to newIndex)
    }

    fun save() {
        if (stepAndIndex.value!!.first != CalibrationStep.Done)
            return
        CalibrationHelper.writeWeakPressure(pressure.value!![0].average().toFloat())
        CalibrationHelper.writeNormalPressure(pressure.value!![1].average().toFloat())
        CalibrationHelper.writeForcePressure(pressure.value!![2].average().toFloat())
        _stepAndIndex.postValue(CalibrationStep.Saved to 0)
    }

    fun resetLastValue() {
        if (stepAndIndex.value!!.first == CalibrationStep.WeakTouch && stepAndIndex.value!!.second == 0)
            return
        val newStep = if (stepAndIndex.value!!.second == 0) CalibrationStep.entries[stepAndIndex.value!!.first.ordinal - 1]
            else stepAndIndex.value!!.first
        val newIndex = (stepAndIndex.value!!.second + 2) % 3
        _pressure.postValue(
            _pressure.value!!.apply {
                this[newStep.ordinal][newIndex] = 0f
            }
        )
        _stepAndIndex.postValue(newStep to newIndex)
    }

    fun resetAll() {
        _stepAndIndex.postValue(CalibrationStep.WeakTouch to 0)
        _pressure.postValue(Array(3) { FloatArray(3) })
    }
}