package com.arshapshap.forcegestures.sample.screen.forcescroll

import com.arshapshap.forcegestures.forcescroll.setForceScrollListener
import com.arshapshap.forcegestures.sample.R
import com.arshapshap.forcegestures.sample.base.BaseFragment
import com.arshapshap.forcegestures.sample.databinding.FragmentForceScrollBinding

class ForceScrollFragment : BaseFragment<FragmentForceScrollBinding>(
    FragmentForceScrollBinding::inflate
) {

    override fun initViews() = with (binding) {
        hintTextView.text = getString(R.string.make, getString(R.string.force_scroll))
        recyclerView.adapter = SimpleAdapter()
        recyclerView.setForceScrollListener()
    }
}