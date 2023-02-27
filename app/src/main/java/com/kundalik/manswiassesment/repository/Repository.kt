package com.kundalik.manswiassesment.repository

import com.kundalik.manswiassesment.api.RetrofitInstance
import com.kundalik.manswiassesment.model.ResponseStatus
import com.kundalik.manswiassesment.model.User
import retrofit2.Response

class Repository {


    suspend fun getUserResponse(name: String, password: String): Response<ResponseStatus> {
        return RetrofitInstance.api.getLoginResponse(name, password)
    }

    suspend fun getUsers(): Response<List<User>> {
        return RetrofitInstance.api.getUsers()
    }

}
