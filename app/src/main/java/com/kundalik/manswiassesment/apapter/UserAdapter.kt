package com.kundalik.manswiassesment.apapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kundalik.manswiassesment.MainViewModel
import com.kundalik.manswiassesment.R
import com.kundalik.manswiassesment.model.User
import org.w3c.dom.Text

class UserAdapter(private val viewModel: MainViewModel): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var mUserList = emptyList<User>()

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.user_row_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val mUser = mUserList[position]
        holder.itemView.findViewById<TextView>(R.id.et_no).text = mUserList[position].Sr_No
        holder.itemView.findViewById<TextView>(R.id.et_name).text = mUserList[position].username
        holder.itemView.findViewById<TextView>(R.id.et_email).text = mUserList[position].email
        holder.itemView.findViewById<TextView>(R.id.et_pass).text = mUserList[position].password
        holder.itemView.findViewById<TextView>(R.id.et_role).text = mUserList[position].role
    }

    override fun getItemCount(): Int {
        return mUserList.size
    }

    fun setData(newUserList: List<User>) {
        mUserList = newUserList
        notifyDataSetChanged()
    }
}