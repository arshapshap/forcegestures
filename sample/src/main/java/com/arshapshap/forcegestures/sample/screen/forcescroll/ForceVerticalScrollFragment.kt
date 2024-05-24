package com.arshapshap.forcegestures.sample.screen.forcescroll

import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import com.arshapshap.forcegestures.forcescroll.setForceScrollListener
import com.arshapshap.forcegestures.sample.R
import com.arshapshap.forcegestures.sample.base.BaseFragment
import com.arshapshap.forcegestures.sample.databinding.FragmentForceScrollVerticalBinding

internal class ForceVerticalScrollFragment : BaseFragment<FragmentForceScrollVerticalBinding>(
    FragmentForceScrollVerticalBinding::inflate
) {

    override fun initViews() = with (binding) {
        hintTextView.text = getString(R.string.make, getString(R.string.force_scroll))
        recyclerView.adapter = SimpleAdapter(LinearLayout.VERTICAL)
        recyclerView.setForceScrollListener()
        testHorizontalScrollButton.setOnClickListener {
            findNavController().navigate(R.id.action_verticalStroll_to_horizontalScroll)
        }
    }
}