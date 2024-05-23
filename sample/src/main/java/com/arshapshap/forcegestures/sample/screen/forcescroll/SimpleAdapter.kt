package com.arshapshap.forcegestures.sample.screen.forcescroll

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.arshapshap.forcegestures.sample.databinding.ItemIconWithTextNarrowBinding
import com.arshapshap.forcegestures.sample.databinding.ItemIconWithTextWideBinding

internal class SimpleAdapter(
    private val orientation: Int
) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (orientation == LinearLayout.VERTICAL)
            WideItemViewHolder(binding = inflateWideItem(parent))
        else
            NarrowItemViewHolder(binding = inflateNarrowItem(parent))
    }

    override fun getItemCount(): Int = 100

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind(position)

    private fun inflateWideItem(parent: ViewGroup) =
        ItemIconWithTextWideBinding.inflate(LayoutInflater.from(parent.context))

    private fun inflateNarrowItem(parent: ViewGroup) =
        ItemIconWithTextNarrowBinding.inflate(LayoutInflater.from(parent.context))
}
