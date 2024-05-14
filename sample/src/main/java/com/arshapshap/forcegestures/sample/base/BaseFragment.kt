package com.arshapshap.forcegestures.sample.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding>(
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
        return binding.root
    }

    abstract fun initViews()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private var clearResultJob: Job? = null

    protected fun TextView.clearAfterDelay() {
        clearResultJob?.cancel()
        clearResultJob = lifecycleScope.launch {
            delay(1500)
            text = ""
        }
    }
}