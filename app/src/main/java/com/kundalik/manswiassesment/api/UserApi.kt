package com.kundalik.manswiassesment.api

import com.kundalik.manswiassesment.model.ResponseStatus
import com.kundalik.manswiassesment.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserApi {

    @POST("hpcl_api/API/Login_api.php")
    suspend fun getLoginResponse(
        @Query("name") name: String,
        @Query("password") password: String,
    ): Response<ResponseStatus>

    @GET("/hpcl_api/API/Show_User.php")
    suspend fun getUsers() : Response<List<User>>

}

