package com.example.paybackcodingtask.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.ImageModel
import com.example.paybackcodingtask.databinding.ItemImagesListBinding


class ImagesAdapter(private val onItemClicked: (ImageModel) -> Unit) :
    PagingDataAdapter<ImageModel, ImagesAdapter.ImageViewHolder>(DiffCallBack()) {

    class ImageViewHolder(private val binding: ItemImagesListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(image: ImageModel, onItemClicked: (ImageModel) -> Unit) {
            binding.apply {
                imageModel = image
                tags.isSelected = true
                root.setOnClickListener {
                    onItemClicked(image)
                }
            }
        }
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(image = getItem(position)!!, onItemClicked)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageViewHolder {
        return ImageViewHolder(
            ItemImagesListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    class DiffCallBack : DiffUtil.ItemCallback<ImageModel>() {
        override fun areItemsTheSame(
            oldItem: ImageModel,
            newItem: ImageModel
        ): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(
            oldItem: ImageModel,
            newItem: ImageModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}