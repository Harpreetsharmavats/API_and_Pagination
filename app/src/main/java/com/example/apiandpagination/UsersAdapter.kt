package com.example.apiandpagination

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apiandpagination.Modals.User
import com.example.apiandpagination.databinding.UsersBinding

class UsersAdapter(private val user: MutableList<User>) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
       return UserViewHolder(UsersBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int = user.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
       holder.bind(position)
    }
    fun setUser(newUser: List<User>) {
        user.clear()
        user.addAll(newUser)
        notifyDataSetChanged() // Notify adapter to refresh
    }
    inner class UserViewHolder(private val binding: UsersBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.id.text= user[position].id
            binding.name.text = user[position].name
        }

    }
}