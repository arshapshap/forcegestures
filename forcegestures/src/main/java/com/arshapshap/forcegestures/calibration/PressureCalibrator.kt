package com.arshapshap.forcegestures.calibration

import android.content.SharedPreferences
import com.arshapshap.forcegestures.calibration.PressureCalibrator.forcePressure
import com.arshapshap.forcegestures.calibration.PressureCalibrator.weakPressure

private const val PREFERENCES_KEY_PREFIX = "FORCE_GESTURES_PRESSURE"
private const val PREFERENCES_KEY_WEAK_PRESSURE = "$PREFERENCES_KEY_PREFIX/WEAK_PRESSURE"
private const val PREFERENCES_KEY_FORCE_PRESSURE = "$PREFERENCES_KEY_PREFIX/FORCE_PRESSURE"

/**
 * Helper class for calibrating force touch pressure values.
 *
 * This class provides methods for saving and loading calibrated weak and force pressure values,
 * which can be used to adjust the pressure threshold for detecting force touch events.
 *
 * The calibration values are stored in [SharedPreferences] using the [PressureCalibrator.Editor] class.
 *
 * @property weakPressure The calibrated weak pressure value, ranging from 0.0 (no pressure) to [forcePressure].
 * @property forcePressure The calibrated force pressure value, ranging from [weakPressure] to 1.0 (maximum pressure).
 */
object PressureCalibrator {

    private var _weakPressure: Float = Float.MIN_VALUE
    private var _forcePressure: Float = Float.MAX_VALUE

    /** The calibrated weak pressure value, ranging from 0.0 (no pressure) to [forcePressure]. */
    val weakPressure get() = _weakPressure

    /** The calibrated force pressure value, ranging from [weakPressure] to 1.0 (maximum pressure). */
    val forcePressure get() = _forcePressure

    /**
     * Editor class for saving and loading calibrated pressure values to and from [SharedPreferences].
     *
     * @property sharedPreferences The [SharedPreferences] instance to use for storing and retrieving calibrated pressure values.
     */
    class Editor(private val sharedPreferences: SharedPreferences) {

        /**
         * Saves the provided weak and force pressure values to [SharedPreferences].
         *
         * The weak pressure value represents the lower threshold for detecting force touch events.
         * The force pressure value represents the upper threshold for detecting force touch events.
         *
         * @param weakPressure The weak pressure value to save, ranging from 0.0 (no pressure) to [forcePressure].
         * @param forcePressure The force pressure value to save, ranging from [weakPressure] to 1.0 (maximum pressure).
         *
         * @throws CalibrationException
         */
        fun savePressure(weakPressure: Float, forcePressure: Float) {
            if (weakPressure > forcePressure)
                throw CalibrationException(weakPressure, forcePressure)
            sharedPreferences.edit().apply {
                _weakPressure = weakPressure.coerceAtLeast(0f)
                _forcePressure = forcePressure.coerceAtMost(1f)
                putFloat(PREFERENCES_KEY_WEAK_PRESSURE, weakPressure)
                putFloat(PREFERENCES_KEY_FORCE_PRESSURE, forcePressure)
            }.apply()
        }

        /**
         * Loads the previously saved weak and force pressure values from [SharedPreferences].
         *
         * If no values are found in [SharedPreferences], the default values ([Float.MIN_VALUE] for weak pressure, [Float.MAX_VALUE] for force pressure) will be used.
         */
        fun loadPressure() = with(sharedPreferences) {
            _weakPressure = getFloat(PREFERENCES_KEY_WEAK_PRESSURE, Float.MIN_VALUE)
            _forcePressure = getFloat(PREFERENCES_KEY_FORCE_PRESSURE, Float.MAX_VALUE)
        }
    }
}