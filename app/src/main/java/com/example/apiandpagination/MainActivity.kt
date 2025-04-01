package com.example.apiandpagination

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.apiandpagination.Modals.APIInterface
import com.example.apiandpagination.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
     private lateinit var viewModel: UserViewModel
    private val adapter = UsersAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val retrofitInstance = APIInterface.getInstance()
        val mainRepository = MainRepository(retrofitInstance)

        binding.rv.adapter = adapter

        viewModel = ViewModelProvider(this,ViewModelFactory(mainRepository))[UserViewModel::class.java]

        viewModel.user.observe(this) { user ->
            adapter.setUser(user)
        }

        viewModel.error.observe(this){
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.loading.observe(this){
            if (it){
                binding.progressBar.visibility =View.VISIBLE
            }else{
                binding.progressBar.visibility = View.GONE
            }
        }

        viewModel.getUser()


    }
}