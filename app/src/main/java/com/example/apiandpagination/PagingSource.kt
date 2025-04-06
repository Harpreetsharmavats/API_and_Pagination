package com.example.apiandpagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.apiandpagination.Modals.UsersItem

class PagingSource(val repository: MainRepository): PagingSource<Int,UsersItem>() {
    override fun getRefreshKey(state: PagingState<Int, UsersItem>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UsersItem> {
        val page = params.key ?: 1
return try {
    val response = repository.getUser(page)
    val resultList = response.body() ?: emptyList()
    LoadResult.Page(
        data = resultList,
        prevKey = if(page == 1) null else page -1,
        nextKey = if (resultList.isEmpty()) null else page +1

    )
} catch (e : Exception){
    LoadResult.Error(e)
}
    }
}