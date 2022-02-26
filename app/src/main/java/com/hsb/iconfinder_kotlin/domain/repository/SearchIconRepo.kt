package com.hsb.iconfinder_kotlin.domain.repository

import com.hsb.iconfinder_kotlin.domain.model.IconFinder

interface SearchIconRepo {

    suspend fun getSearchIcon(query: String,count: Int) : IconFinder
    suspend fun getSearchIcon(query: String) : IconFinder

}