package com.example.homework_008

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_008.databinding.ItemABinding
import com.example.homework_008.databinding.ItemBBinding



class UserAdapter(private val userList: MutableList<User>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {




    companion object {
        private const val USER_A = 11
        private const val USER_B = 12

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =


        if (viewType == USER_A) {
            ViewHolderA(ItemABinding.inflate(LayoutInflater.from(parent.context), parent, false))
        } else {
            ViewHolderB(ItemBBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {



        if (holder is ViewHolderA) {
            holder.onBind()
        } else if (holder is ViewHolderB) {
            holder.onBind()
        }
    }

    override fun getItemCount() = userList.size


    override fun getItemViewType(position: Int): Int {


        return if (userList[position].name == null) USER_B else USER_A
    }

    inner class ViewHolderA(private val binding: ItemABinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var user: User
        fun onBind() {
            user = userList[adapterPosition]
            binding.tVName.text = user.name
            binding.tVNickName.text = user.nickName
            //binding.iVA.setImageResource(user.image)
        }

    }

    inner class ViewHolderB(private val binding: ItemBBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var user: User
        fun onBind() {
            user = userList[adapterPosition]

            binding.tVNickName.text = user.nickName
            //binding.iVB.setImageResource(user.image)
        }

    }


}