package com.example.apiandpagination

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apiandpagination.Modals.RandomApiItem
import com.example.apiandpagination.databinding.UsersBinding

class UsersAdapter(private var user: List<RandomApiItem>) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
       return UserViewHolder(UsersBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    fun setUser(newUser: List<RandomApiItem>) {
        user = newUser
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = user.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
       holder.bind(user[position])
    }

    inner class UserViewHolder(private val binding: UsersBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(user: RandomApiItem) {
            binding.id.text= user.id.toString()
            binding.name.text = user.first_name
        }

    }
}