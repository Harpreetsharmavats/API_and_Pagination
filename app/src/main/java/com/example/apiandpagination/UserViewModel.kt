package com.example.apiandpagination

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiandpagination.Modals.User
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext



class UserViewModel constructor(private val mainRepository: MainRepository) : ViewModel() {
    val error = MutableLiveData<String>()
    val user = MutableLiveData<List<User>>()
    val loading = MutableLiveData<Boolean>()
    var job: Job? = null
    private var currentPage = 1
    private var isLastPage = false
    private var isLoading = false
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception Handled: ${throwable.localizedMessage}")
    }

   fun getUser(){
       if (isLoading || isLastPage) return
       loading.postValue(true)
       job = viewModelScope.launch(Dispatchers.IO + exceptionHandler){
           val response = mainRepository.getUser(currentPage)
           withContext(Dispatchers.Main){
               if (response.isSuccessful){
                   response.body().let {
                       val currentList = user.value?.toMutableList()


                       currentPage++

                   }
                   Log.d("Fetch","success")
                       loading.value = false
               }else{
                   onError("Error : ${response.message()}")
               }

           }
       }
   }

    private fun onError(message: String) {
        error.postValue(message)
        loading.value = true
    }
}