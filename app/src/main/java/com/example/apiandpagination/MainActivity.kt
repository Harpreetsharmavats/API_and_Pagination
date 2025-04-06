package com.example.apiandpagination

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.apiandpagination.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
     private lateinit var viewModel: UserViewModel
private val adapter = UsersAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val retrofitInstance = APIInterface.getInstance()
        val mainRepository = MainRepository(retrofitInstance)



        viewModel = ViewModelProvider(this,ViewModelFactory(mainRepository))[UserViewModel::class.java]
        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(this@MainActivity)
      lifecycleScope.launch {
          viewModel.userPagingFlow.collectLatest {
              Log.d("Fetch","DAta fetched")
             adapter.submitData(it)

          }
      }


    }
}