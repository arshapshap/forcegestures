package com.arshapshap.forcegestures.calibration

import android.content.SharedPreferences

private const val PREFERENCES_KEY_PREFIX = "FORCE_GESTURES_PRESSURE"
private const val PREFERENCES_KEY_WEAK_PRESSURE = "$PREFERENCES_KEY_PREFIX/WEAK_PRESSURE"
private const val PREFERENCES_KEY_FORCE_PRESSURE = "$PREFERENCES_KEY_PREFIX/FORCE_PRESSURE"

object PressureCalibrator {

    private var _weakPressure: Float = 0f
    private var _forcePressure: Float = 0f
    val weakPressure get() = _weakPressure
    val forcePressure get() = _forcePressure
    val calibrationRequired get() = _weakPressure == 0f || _forcePressure == 0f

    class Editor(private val sharedPreferences: SharedPreferences) {

        fun saveWeakPressure(value: Float) = sharedPreferences.edit().apply {
            _weakPressure = value
            putFloat(PREFERENCES_KEY_WEAK_PRESSURE, value)
        }.apply()

        fun saveForcePressure(value: Float) = sharedPreferences.edit().apply {
            _forcePressure = value
            putFloat(PREFERENCES_KEY_FORCE_PRESSURE, value)
        }.apply()

        fun loadPressure() = with(sharedPreferences) {
            _weakPressure = getFloat(PREFERENCES_KEY_WEAK_PRESSURE, 0f)
            _forcePressure = getFloat(PREFERENCES_KEY_FORCE_PRESSURE, 0f)
        }
    }
}