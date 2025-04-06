package com.example.apiandpagination

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.apiandpagination.Modals.UsersItem
import com.example.apiandpagination.databinding.UsersBinding

class UsersAdapter() : PagingDataAdapter<UsersItem,UsersAdapter.UserViewHolder>(DiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
       return UserViewHolder(UsersBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class UserViewHolder(private val binding: UsersBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(user: UsersItem) {
            binding.id.text= user.id.toString()
            binding.name.text = user.name
        }

    }
    class DiffCallback : DiffUtil.ItemCallback<UsersItem>() {
        override fun areItemsTheSame(oldItem: UsersItem, newItem: UsersItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UsersItem, newItem: UsersItem): Boolean {
            return oldItem == newItem
        }
    }
}