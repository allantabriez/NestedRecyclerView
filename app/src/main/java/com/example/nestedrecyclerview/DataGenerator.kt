package com.example.nestedrecyclerview

object DataGenerator {
    fun getFavorites(): CategoryMenu {
        val favoriteList = ArrayList<FoodMenu>()
        favoriteList.add(
            FoodMenu(
                "Indomie + Cumi Geprek", "Indomie + Cumi Geprek + Sambal + Lalapan",
                "Rp 30.000", true, null, R.drawable.image_dummy_food_details
            )
        )
        favoriteList.add(
            FoodMenu(
                "Indomie + Ayam Geprek", "Indomie + Ayam Geprek + Sambal + Lalapan",
                "Rp 21.000", false, null, R.drawable.image_dummy_food_details
            )
        )
        return CategoryMenu("Menu Andalan", favoriteList)
    }

    fun getPopulars(): CategoryMenu {
        val popularList = listOf(
            FoodMenu("Nasi Ayam Geprek", "Nasi + Ayam Geprek + Sambal + Lalapan",
                "Rp 23.000", false, "17.000", R.drawable.image_dummy_food_details),
            FoodMenu("Indomie + Cumi Geprek", "Indomie + Cumi Geprek + Sambal + Lalapan",
                "Rp 30.000", true, null, R.drawable.image_dummy_food_details),
            FoodMenu("Es Teh", null, "Rp 3.000", false,
                null, R.drawable.image_dummy_food_details)
        )
        return CategoryMenu("Paling Populer", popularList)
    }

    fun getChickens(): CategoryMenu {
        val chickenList = listOf(
            FoodMenu("Nasi + Ayam Geprek", "Indomie + Cumi Geprek + Sambal + Lalapan",
                "Rp 23.000", false, "Rp 17.000", R.drawable.image_dummy_food_details),
            FoodMenu("Indomie + Ayam Geprek", "Indomie + Ayam Geprek + Sambal + Lalapan",
                "Rp 21.000", false, null, R.drawable.image_dummy_food_details)
        )
        return CategoryMenu("Ayam Geprek", chickenList)
    }

    fun getDrinks(): CategoryMenu {
        val drinkList = listOf(FoodMenu("Es Teh", null, "Rp 3.000", false, null,
            R.drawable.image_dummy_food_details)
        )
        return CategoryMenu("Minuman", drinkList)
    }

    fun getMenus(): List<CategoryMenu> {
        return listOf(getFavorites(), getPopulars(), getChickens(), getDrinks())
    }
}