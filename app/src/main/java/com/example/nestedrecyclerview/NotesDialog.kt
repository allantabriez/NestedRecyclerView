package com.example.nestedrecyclerview

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.example.nestedrecyclerview.databinding.ItemDialogBinding

class NotesDialog: DialogFragment() {

    companion object{
        var foodItem = "foodItem"
    }

    private var _binding: ItemDialogBinding? = null
    private val binding get() = _binding!!

    var onSaveNotes: ((String) -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ItemDialogBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val item = arguments?.getParcelable(foodItem) as FoodMenu?
        Log.d("FoodMenuNotes", item.toString())
        with(binding){
            itemTitle.text = item?.name
            itemDescription.text = item?.description
            Glide.with(this@NotesDialog)
                .load(item?.img)
                .into(itemImage)
            saveBtn.setOnClickListener {
                onSaveNotes?.invoke(inputNotes.text.toString())
                dialog?.dismiss()
            }
        }
    }

    override fun onDetach() {
        super.onDetach()
        _binding = null
    }
}