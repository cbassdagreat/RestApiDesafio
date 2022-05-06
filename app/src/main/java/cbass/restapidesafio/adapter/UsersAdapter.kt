package cbass.restapidesafio.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import cbass.restapidesafio.R
import cbass.restapidesafio.databinding.ItemLayoutBinding
import cbass.restapidesafio.model.Users
import cbass.restapidesafio.model.UsersItem

class UsersAdapter :RecyclerView.Adapter<UsersAdapter.CustomViewHolder>() {
    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        private val binding = ItemLayoutBinding.bind(itemView)

        fun bindData(usersItem: UsersItem)
        {
            with(binding)
            {
                tvEmail.text = usersItem.email
                tvName.text = usersItem.name
                tvPhone.text = usersItem.phone
            }

        }
    }

    var list:List<UsersItem> = Users()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsersAdapter.CustomViewHolder, position: Int) {
        holder.bindData(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateData(users: Users)
    {
        list = users
        notifyDataSetChanged()
    }
}