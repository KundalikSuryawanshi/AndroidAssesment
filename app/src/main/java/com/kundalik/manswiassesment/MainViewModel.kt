package com.kundalik.manswiassesment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kundalik.manswiassesment.model.ResponseStatus
import com.kundalik.manswiassesment.model.User
import com.kundalik.manswiassesment.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val mResponse : MutableLiveData<Response<ResponseStatus>> = MutableLiveData()
    val mUserResponse: MutableLiveData<Response<List<User>>> = MutableLiveData()

    fun getUserResponse(name: String, password: String) {
        viewModelScope.launch {
            val response = repository.getUserResponse(name, password)
            mResponse.value = response
        }
    }
    fun getUsers() {
        viewModelScope.launch {
            val response = repository.getUsers()
            mUserResponse.value = response
        }
    }

}