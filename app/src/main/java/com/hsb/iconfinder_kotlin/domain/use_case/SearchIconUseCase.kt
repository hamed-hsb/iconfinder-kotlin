package com.hsb.iconfinder_kotlin.domain.use_case

import com.hsb.iconfinder_kotlin.common.Resource
import com.hsb.iconfinder_kotlin.data.repository.SearchIconRepoImpl
import com.hsb.iconfinder_kotlin.domain.model.IconFinder
import com.hsb.iconfinder_kotlin.domain.repository.SearchIconRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SearchIconUseCase @Inject constructor(private val repo: SearchIconRepo) {


    operator fun invoke( query: String, count: Int) : Flow<Resource<IconFinder>> = flow{
        try {

            emit(Resource.Loading<IconFinder>())

            val icons = repo.getSearchIcon(query, count)

            emit(Resource.Success<IconFinder>(icons))

        }catch(e: HttpException) {
            emit(Resource.Error<IconFinder>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<IconFinder>("Couldn't reach server. Check your internet connection."))
        }

    }
}