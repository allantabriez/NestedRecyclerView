package com.example.nestedrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.databinding.ItemParentBinding

class ParentAdapter(private val fm: FragmentManager): RecyclerView.Adapter<ParentAdapter.ListView>() {

    private val list = ArrayList<CategoryMenu>()

    fun setData(list: List<CategoryMenu>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
    private val viewPool = RecyclerView.RecycledViewPool()
    inner class ListView(private val binding: ItemParentBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(menu: CategoryMenu){
            with(binding){
                constraintLayout.setOnClickListener {
                    groupBtn.isActivated = !groupBtn.isActivated
                    if (groupBtn.isActivated) childRV.visibility = View.VISIBLE
                    else childRV.visibility = View.GONE
                }
                val childLayoutManager = LinearLayoutManager(childRV.context, RecyclerView.VERTICAL, false)
                childLayoutManager.initialPrefetchItemCount = 4
                with(childRV){
                    layoutManager = childLayoutManager
                    adapter = ChildAdapter(menu.children, fm)
                    setRecycledViewPool(viewPool)
                }
                groupTitle.text = menu.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListView {
        val binding = ItemParentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListView(binding)
    }

    override fun onBindViewHolder(holder: ListView, position: Int) = holder.bind(list[position])

    override fun getItemCount() = list.size
}