package com.arshapshap.forcegestures

import com.arshapshap.forcegestures.ForceGesturesInformer.calibrationRequired
import com.arshapshap.forcegestures.ForceGesturesInformer.doesDeviceSupportForceTouches
import com.arshapshap.forcegestures.ForceGesturesInformer.readyForUse
import com.arshapshap.forcegestures.calibration.PressureCalibrator
import com.arshapshap.forcegestures.calibration.PressureCalibrator.forcePressure
import com.arshapshap.forcegestures.calibration.PressureCalibrator.weakPressure

/**
 * Helper class for providing information about the force gestures library and device compatibility.
 *
 * This class offers properties that indicate whether the library is ready to use, whether calibration
 * is required, and whether the current device supports force touches (pressure sensitivity).
 *
 * @property readyForUse Indicates whether the library is ready to use, which is true if calibration is completed and the device supports force touches.
 * @property calibrationRequired Indicates whether calibration is required, which is true if either [PressureCalibrator.weakPressure] or [PressureCalibrator.forcePressure] is at its default value.
 * @property doesDeviceSupportForceTouches Indicates whether the current device supports force touches, which is true if [PressureCalibrator.weakPressure] is not equal to [PressureCalibrator.forcePressure].
 */
object ForceGesturesInformer {

    /** Indicates whether the library is ready to use (true if calibration is completed and the device supports force touches). */
    val readyForUse get() = !calibrationRequired && doesDeviceSupportForceTouches

    /** Indicates whether calibration is required (true if either [PressureCalibrator.weakPressure] or [PressureCalibrator.forcePressure] is at its default value). */
    val calibrationRequired get() = weakPressure == Float.MIN_VALUE || forcePressure == Float.MAX_VALUE

    /** Indicates whether the device supports force touches (true if [PressureCalibrator.weakPressure] is not equal to [PressureCalibrator.forcePressure]). */
    val doesDeviceSupportForceTouches get() = weakPressure != forcePressure
}