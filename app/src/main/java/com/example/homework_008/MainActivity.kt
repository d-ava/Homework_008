package com.example.homework_008

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.homework_008.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    var dataList111 = mutableListOf<User>()

    private val adapter = UserAdapter()
    private val layoutManager = GridLayoutManager(this, 2)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.recyclerLayout.adapter = adapter
        binding.recyclerLayout.layoutManager = layoutManager



    }
}