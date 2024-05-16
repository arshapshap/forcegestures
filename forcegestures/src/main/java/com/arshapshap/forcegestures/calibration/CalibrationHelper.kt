package com.arshapshap.forcegestures.calibration

object CalibrationHelper {

    private var _weakPressure: Float = 0f
    private var _normalPressure: Float = 0f
    private var _forcePressure: Float = 0f
    val weakPressure get() = _weakPressure
    val normalPressure get() = _normalPressure
    val forcePressure get() = _forcePressure
    val calibrationRequired get() = _weakPressure == 0f || _normalPressure == 0f || _forcePressure == 0f

    fun writeWeakPressure(pressure: Float) {
        _weakPressure = pressure
    }

    fun writeNormalPressure(pressure: Float) {
        _normalPressure = pressure
    }

    fun writeForcePressure(pressure: Float) {
        _forcePressure = pressure
    }
}