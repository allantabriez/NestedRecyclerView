package com.example.nestedrecyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FoodMenu(
    val name: String,
    val description: String?,
    val price: String,
    val isEmpty: Boolean,
    val discountedPrice: String?,
    val img: Int?
): Parcelable
