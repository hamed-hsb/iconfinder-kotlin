package com.hsb.iconfinder_kotlin.data.repository

import com.hsb.iconfinder_kotlin.data.remote.ApiService
import com.hsb.iconfinder_kotlin.domain.model.IconFinder
import com.hsb.iconfinder_kotlin.domain.repository.SearchIconRepo
import javax.inject.Inject

class SearchIconRepoImpl @Inject constructor(private val api: ApiService): SearchIconRepo {
    override suspend fun getSearchIcon(query: String, count: Int): IconFinder {
        return api.getSearchIcon(query,count)
    }

    override suspend fun getSearchIcon(query: String): IconFinder {
        return api.getSearchIcon(query,100)
    }


}