package com.arshapshap.forcegestures.sample.screen.forcescroll

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.arshapshap.forcegestures.sample.R
import com.arshapshap.forcegestures.sample.databinding.ItemIconWithTextNarrowBinding
import com.arshapshap.forcegestures.sample.databinding.ItemIconWithTextWideBinding

internal abstract class ViewHolder(
    binding: ViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    abstract fun onBind(position: Int)
}

internal class WideItemViewHolder(
    private val binding: ItemIconWithTextWideBinding
) : ViewHolder(binding) {

    override fun onBind(position: Int) = with(binding) {
        textView.text = root.resources.getString(R.string.recycler_view_item, position)
    }
}

internal class NarrowItemViewHolder(
    private val binding: ItemIconWithTextNarrowBinding
) : ViewHolder(binding) {

    override fun onBind(position: Int) = with(binding) {
        textView.text = root.resources.getString(R.string.recycler_view_item, position)
    }
}