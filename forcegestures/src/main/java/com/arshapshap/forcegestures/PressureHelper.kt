package com.arshapshap.forcegestures

import android.view.MotionEvent
import android.view.View
import com.arshapshap.forcegestures.calibration.PressureCalibrator
import com.arshapshap.forcegestures.calibration.PressureCalibrator.forcePressure
import com.arshapshap.forcegestures.calibration.PressureCalibrator.weakPressure
import com.arshapshap.forcegestures.forceclick.setOnForceClickListener

/**
 * The default force touch pressure threshold value.
 *
 * This value represents the normalized pressure value at which a touch event is considered a force touch.
 * The default value is 0.8, but it can be overridden by using the [View.setOnForceClickListener] and
 * other related extension functions that accept a custom threshold value.
 */
const val DEFAULT_FORCE_TOUCH_THRESHOLD = 0.8f

/**
 * Helper class for working with pressure values from touch events.
 *
 * This class provides utility methods for detecting force touch events, retrieving raw and normalized
 * pressure values, and calculating pressure deviance.
 *
 * @see [PressureCalibrator]
 */
object PressureHelper {

    /**
     * Checks if the given [MotionEvent] represents a force touch based on the specified [threshold].
     *
     * A force touch is detected when the normalized pressure value of the event (obtained via [getNormalizedPressure])
     * is greater than or equal to the provided [threshold].
     *
     * @param event The [MotionEvent] to check for a force touch.
     * @param threshold The force touch pressure threshold value (in the range 0.0 to 1.0). Defaults to [DEFAULT_FORCE_TOUCH_THRESHOLD].
     * @return True if the event represents a force touch, false otherwise.
     */
    fun isForceTouch(event: MotionEvent, threshold: Float = DEFAULT_FORCE_TOUCH_THRESHOLD): Boolean {
        return getNormalizedPressure(event) >= threshold
    }

    /**
     * Retrieves the raw pressure value from the given [MotionEvent].
     *
     * The raw pressure value is a float between 0.0 (no pressure) and 1.0 (maximum pressure),
     * as reported by the device's touch sensor.
     *
     * @param event The [MotionEvent] to retrieve the raw pressure value from.
     * @return The raw pressure value of the event.
     */
    fun getRawPressure(event: MotionEvent): Float {
        return event.pressure
    }

    /**
     * Retrieves the normalized pressure value from the given [MotionEvent].
     *
     * The normalized pressure value is a float between 0.0 (no pressure) and 1.0 (maximum pressure),
     * calculated based on the calibrated weak and force pressure values from [PressureCalibrator].
     * If if the library is not ready for use (as determined by [ForceGesturesInformer.readyForUse]),
     * this method returns a constant value of 0.5.
     *
     * @param event The [MotionEvent] to retrieve the normalized pressure value from.
     * @return The normalized pressure value of the event, or 0.5 if the library is not ready for use.
     */
    fun getNormalizedPressure(event: MotionEvent): Float {
        if (!ForceGesturesInformer.readyForUse)
            return 0.5f
        return ((event.pressure - weakPressure) / (forcePressure - weakPressure))
            .coerceIn(0f, 1f)
    }

    /**
     * Calculates the pressure deviance value from the given [MotionEvent].
     *
     * The pressure deviance value is a float representing the normalized pressure value multiplied by 2.
     * It is used to adjust the scroll or scale velocity based on the applied pressure.
     *
     * @param event The [MotionEvent] to calculate the pressure deviance value from.
     * @return The pressure deviance value of the event.
     */
    fun getPressureDeviance(event: MotionEvent): Float {
        return getNormalizedPressure(event) / 0.5f
    }
}