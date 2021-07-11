package com.example.nestedrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var menuAdapter: ParentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        menuAdapter = ParentAdapter(this.supportFragmentManager)
        setupRecyclers(binding)
    }

    private fun setupRecyclers(binding: ActivityMainBinding){
        with(binding.groupRV){
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            adapter = menuAdapter
        }
        menuAdapter.setData(DataGenerator.getMenus())
    }
}