package com.example.market.model.list

import com.example.market.R

data class ListBanner(
    val imgBanner: Int
)

val dummyListBanner = listOf(
    ListBanner(R.drawable.banner1),
    ListBanner(R.drawable.banner2),
    ListBanner(R.drawable.banner3)
)