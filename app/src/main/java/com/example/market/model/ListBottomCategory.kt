package com.example.market.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.market.R

data class ListBottomCategory(
    @DrawableRes val imageTopCategory: Int,
    @StringRes val textTopCategory: Int
)


val dummyListBottomCategory = listOf(
    R.drawable.play to R.string.txt_category_sport,
    R.drawable.show to R.string.txt_category_for_you,
    R.drawable.travel to R.string.txt_category_food,
    R.drawable.topup to R.string.txt_category_laptop,
    R.drawable.cicil to R.string.txt_live,
    R.drawable.official to R.string.txt_category_life_style
).map{
    ListCategory(
        it.first, it.second
    )
}