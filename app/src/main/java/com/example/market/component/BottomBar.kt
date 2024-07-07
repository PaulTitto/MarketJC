package com.example.market.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.market.R
import com.example.market.model.list.BottomBarItem
import com.example.market.ui.theme.MarketTheme

@Composable
fun BottomBar(navController: NavController, modifier: Modifier = Modifier) {
    NavigationBar(modifier) {
        val bottomNavigation = listOf(
            BottomBarItem(
                title = stringResource(id = R.string.txt_home),
                icon = Icons.Default.Home,
                route = "marketapp"
            ),
            BottomBarItem(
                title = stringResource(id = R.string.txt_list),
                icon = Icons.Default.List,
                route = "list"
            ),
            BottomBarItem(
                title = stringResource(id = R.string.txt_notification),
                icon = Icons.Default.Notifications,
                route = "notifications"
            ),
            BottomBarItem(
                title = stringResource(id = R.string.txt_profile),
                icon = Icons.Default.Person,
                route = "profile"
            ),
        )
        bottomNavigation.forEach { item ->
            NavigationBarItem(
                selected = item.title == stringResource(id = R.string.txt_home),
                onClick = {
                    navController.navigate(item.route)
                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.title)
                },
                label = {
                    Text(text = item.title)
                }
            )
        }
    }
}


//@Preview
//@Composable
//fun BottomBarPreview() {
//    MarketTheme {
//        BottomBar()
//    }
//}