package com.arshapshap.forcegestures.calibration

/**
 * Exception thrown when there is an error during the pressure calibration process.
 *
 * This exception is thrown when an attempt is made to save a weak pressure value that is greater than
 * the force pressure value during the calibration process. This situation is invalid, as the weak pressure
 * value should always be less than or equal to the force pressure value.
 * @property weakPressure The weak pressure value that caused the exception.
 * @property forcePressure The force pressure value that caused the exception.
 *
 * @constructor Creates a new instance of [CalibrationException] with the provided weak and force pressure values.
 * @see PressureCalibrator.Editor
 */
class CalibrationException(private val weakPressure: Float, private val forcePressure: Float) :
    IllegalArgumentException("Weak pressure ($weakPressure) cannot be greater than force pressure ($forcePressure)")