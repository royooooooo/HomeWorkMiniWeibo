package com.thoughtworks.homeworkminiweibo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.thoughtworks.homeworkminiweibo.R
import com.thoughtworks.homeworkminiweibo.databinding.ViewMomentItemBinding
import com.thoughtworks.homeworkminiweibo.data.Moment

class MomentListAdapter : ListAdapter<Moment, ViewHolder>(MomentDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return MomentHolder(
            ViewMomentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as MomentHolder).bind(item)
    }

    private class MomentHolder(private val viewBinding: ViewMomentItemBinding) :
        ViewHolder(viewBinding.root) {
        fun bind(item: Moment) {
            viewBinding.plantItemTitle.text = item.text
            viewBinding.momentLayout.setOnClickListener {
                it.findNavController().navigate(R.id.action_listFragment_to_detailFragment)
            }
            Glide.with(viewBinding.root).load(item.picUrl).into(viewBinding.momentImg)
        }
    }


}

private class MomentDiffCallback : DiffUtil.ItemCallback<Moment>() {
    override fun areItemsTheSame(oldItem: Moment, newItem: Moment) = oldItem.id == newItem.id


    override fun areContentsTheSame(oldItem: Moment, newItem: Moment) = oldItem == newItem

}
