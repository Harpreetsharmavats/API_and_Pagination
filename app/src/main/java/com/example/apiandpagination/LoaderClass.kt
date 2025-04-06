package com.example.apiandpagination


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.apiandpagination.databinding.ItemloaderBinding

class LoaderAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<LoaderAdapter.LoaderViewHolder>() {

    override fun onBindViewHolder(holder: LoaderViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoaderViewHolder {
        val binding = ItemloaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LoaderViewHolder(binding)
    }

    inner class LoaderViewHolder(private val binding: ItemloaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(loadState: LoadState) {
            binding.progressBar.isVisible = loadState is LoadState.Loading
            binding.retryButton.isVisible = loadState is LoadState.Error
            binding.retryButton.setOnClickListener { retry() }
        }
    }
}
