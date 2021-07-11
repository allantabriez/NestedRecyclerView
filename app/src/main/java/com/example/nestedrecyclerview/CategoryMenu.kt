package com.example.nestedrecyclerview

data class CategoryMenu(
    val title: String,
    val children: List<FoodMenu>
)