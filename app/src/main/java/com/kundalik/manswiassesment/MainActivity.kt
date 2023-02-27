package com.kundalik.manswiassesment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kundalik.manswiassesment.databinding.ActivityMainBinding
import com.kundalik.manswiassesment.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        binding.btnLogin.setOnClickListener {
            val name = binding.etUserName.text.toString()
            val password = binding.etUserPassword.text.toString()

            if (name != null && password != null) {
                viewModel.getUserResponse(name, password)
                viewModel.mResponse.observe(this, Observer { response ->
                    Log.d("Response", response.body().toString())
                    binding.etResponse.text = response.body().toString()
                })
            } else {
                Toast.makeText(this, "Enter all the filed", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnNext.setOnClickListener {
            startActivity(Intent(this, UsersActivity::class.java))
        }
    }
}