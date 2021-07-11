package com.example.nestedrecyclerview

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.VerifiedInputEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nestedrecyclerview.databinding.ItemChildBinding

class ChildAdapter(private val list: List<FoodMenu>, private val fm: FragmentManager): RecyclerView.Adapter<ChildAdapter.ListView>() {

    inner class ListView(private val binding: ItemChildBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(menu: FoodMenu){
            with(binding){
                itemName.text = menu.name
                if (menu.isEmpty){
                    itemEmpty.visibility = View.VISIBLE
                    itemPrice.visibility = View.INVISIBLE
                    addItemBtn.isEnabled = false
                } else {
                    itemPrice.text = menu.price
                }
                Glide.with(itemView.context)
                    .load(menu.img)
                    .into(itemImage)
                addItemBtn.setOnClickListener {
                    addItemBtn.visibility = View.GONE
                    addedItemLayout.visibility = View.VISIBLE
                    amountTxt.text = "1"
                }
                minusBtn.setOnClickListener {
                    val amount = amountTxt.text.toString().toInt()
                    val newAmount = amount - 1
                    amountTxt.text = newAmount.toString()
                    if (newAmount == 0){
                        addedItemLayout.visibility = View.GONE
                        addItemBtn.visibility = View.VISIBLE
                    }
                }
                plusBtn.setOnClickListener {
                    val amount = amountTxt.text.toString().toInt()
                    val newAmount = amount + 1
                    amountTxt.text = newAmount.toString()
                }
                notesBtn.setOnClickListener {
                    val notesDialog = NotesDialog()
                    val bundle = Bundle()
                    Log.d("FoodMenuNotes", menu.toString())
                    bundle.putParcelable(NotesDialog.foodItem, menu)
                    notesDialog.arguments = bundle
                    notesDialog.show(fm, NotesDialog::class.java.simpleName)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListView {
        val binding = ItemChildBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListView(binding)
    }

    override fun onBindViewHolder(holder: ListView, position: Int) = holder.bind(list[position])

    override fun getItemCount() = list.size
}