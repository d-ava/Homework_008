package com.example.homework_008

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.homework_008.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    private val userList = mutableListOf<User>(
        User("nameAA", "nickname AA12"),
        User("nameAaA", "nickname AAA"),
        User(nickName = "nickname B"),
        User("nameAA", "nickname AA12"),
        User("nameAaA", "nickname AAA"),
        User(nickName = "nickname B"),
        User("nameAA", "nickname AA12"),
        User("nameAaA", "nickname AAA"),
        User("nameAaA", "nickname AAA"),
        User(nickName = "nickname B")
    )

    private val adapter = UserAdapter()


    private val layoutManager = GridLayoutManager(this, 3)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter.setData(userList)

        binding.recyclerLayout.adapter = adapter
        binding.recyclerLayout.layoutManager = layoutManager



        binding.btnAdd.setOnClickListener {
            onAddButtonClick()

        }


    }

    private fun onAddButtonClick() {

        val name: String? = if (binding.eTName.text.isNullOrBlank()) {
            null
        } else {
            binding.eTName.text.toString()
        }

        val nickname = binding.eTNickName.text.toString()


        val addedUser = User(name = name, nickName = nickname)
        userList.add(addedUser)
        adapter.setData(userList)
        //adapter.notifyDataSetChanged()

    }
}