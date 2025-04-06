package com.example.apiandpagination

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.apiandpagination.Modals.UsersItem
import kotlinx.coroutines.flow.Flow


class UserViewModel(private val mainRepository: MainRepository) : ViewModel() {

    val userPagingFlow : Flow<PagingData<UsersItem>> = Pager(
        config = PagingConfig(pageSize = 1)
    ){
        PagingSource(mainRepository)
    }.flow.cachedIn(viewModelScope)

}