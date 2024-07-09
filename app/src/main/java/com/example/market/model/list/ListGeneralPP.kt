package com.example.market.model.list

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

data class ListPersonlPP(
    val icon: ImageVector,
    val textLarge: String,
    val textSmall: String,
)

val dummyGeneralPP = listOf(
    Triple(Icons.Filled.Person, "Edit Profile", "Change Your Profile"),
    Triple(Icons.Filled.Lock, "Change Password", "Change your Google Account password."),
    Triple(Icons.Filled.LocationOn, "Terms of Use", "The rules, specifications, and requirements for the use of a product or service."),
    Triple(Icons.Filled.DateRange, "Add Card", "Adding Card")
).map { ListPersonlPP(it.first, it.second, it.third) }


val dummyPerformacePP = listOf(
    Triple(Icons.Filled.Person, "Notification", "The act or an instance of notifying. How to use notification in a sentence."),
    Triple(Icons.Filled.Lock, "FAQ", "FAQ stands for Frequently Askes Questions"),
    Triple(Icons.Filled.LocationOn, "Log Out", "The rules, specifications, and requirements for the use of a product or service."),
).map { ListPersonlPP(it.first, it.second, it.third) }