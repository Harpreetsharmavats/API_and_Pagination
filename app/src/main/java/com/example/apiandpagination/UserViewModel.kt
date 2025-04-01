package com.example.apiandpagination

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apiandpagination.Modals.User
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext



class UserViewModel constructor(private val mainRepository: MainRepository) : ViewModel() {
    val error = MutableLiveData<String>()
    val user = MutableLiveData<List<User>>()
    val loading = MutableLiveData<Boolean>()
    var job: Job? = null
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception Handled: ${throwable.localizedMessage}")
    }

   fun getUser(){
       loading.postValue(true)
       job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
           val response = mainRepository.getUser()
           withContext(Dispatchers.Main){
               if (response.isSuccessful){
                   user.postValue(response.body())
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