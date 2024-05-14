package com.arshapshap.forcegestures.sample.screen.forcescroll

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arshapshap.forcegestures.sample.R
import com.arshapshap.forcegestures.sample.databinding.ItemIconWithTextBinding

internal class SimpleAdapter : RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            binding = ItemIconWithTextBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun getItemCount(): Int = 100

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = with (holder.binding) {
        textView.text = root.resources.getString(R.string.recycler_view_item, position)
    }

    internal class ViewHolder(
        val binding: ItemIconWithTextBinding
    ) : RecyclerView.ViewHolder(binding.root)
}
