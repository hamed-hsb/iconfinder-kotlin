package com.hsb.iconfinder_kotlin.domain.repository

import com.hsb.iconfinder_kotlin.domain.model.IconFinder

interface SearchIconRepo {

    fun getSearchIcon() : IconFinder
}