package com.kundalik.manswiassesment

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kundalik.manswiassesment.apapter.UserAdapter
import com.kundalik.manswiassesment.databinding.ActivityUsersBinding
import com.kundalik.manswiassesment.repository.Repository

class UsersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUsersBinding
    private lateinit var viewModel: MainViewModel
    private val userAdapter by lazy { UserAdapter(viewModel) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.getUsers()
        viewModel.mUserResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.let {
                    userAdapter.setData(it)
                    setupRecyclerView()
                }
            } else {
                Toast.makeText(this, response.message().toString(), Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = userAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}