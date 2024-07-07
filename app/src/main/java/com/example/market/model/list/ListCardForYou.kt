package com.example.market.model.list

import com.example.market.R

data class ListCardForYou (
    val img: Int,
    val text: Int
)

val dummyListCardVertikal = listOf(
    R.drawable.banner_vertikal1 to (R.string.txt_desc_first_banner),
    R.drawable.banner_vertikal2 to (R.string.txt_desc_second_banner),
    R.drawable.banner_vertikal3 to (R.string.txt_desc_third_banner),
    R.drawable.banner_vertikal4 to (R.string.txt_desc_fourth_banner),
    R.drawable.banner_vertikal5 to (R.string.txt_desc_five_banner)
).map { ListCardForYou(it.first, it.second) }


