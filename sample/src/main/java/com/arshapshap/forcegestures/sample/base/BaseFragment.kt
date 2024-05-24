package com.arshapshap.forcegestures.sample.base

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.arshapshap.forcegestures.sample.utils.setRippleColor
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

internal abstract class BaseFragment<VB : ViewBinding>(
    private val inflate: Inflate<VB>,
) : Fragment() {

    private var _binding: VB? = null
    protected val binding: VB get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        initViews()
        subscribe()
        return binding.root
    }

    abstract fun initViews()

    open fun subscribe() = Unit

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private var clearResultJob: Job? = null
    private var resetDrawableColorJob: Job? = null

    protected fun TextView.clearAfterDelay() {
        clearResultJob?.cancel()
        clearResultJob = lifecycleScope.launch {
            delay(1500)
            text = ""
        }
    }

    protected fun Drawable.setRippleColorAfterDelay(@ColorInt color: Int) {
        resetDrawableColorJob?.cancel()
        resetDrawableColorJob = lifecycleScope.launch {
            delay(200)
            this@setRippleColorAfterDelay.setRippleColor(color)
        }
    }
}