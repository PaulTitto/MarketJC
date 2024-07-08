package com.example.market.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.market.model.list.ProfileIData
import com.example.market.ui.theme.MarketTheme

@Composable
fun ProfileApp(navController: NavController, modifier: Modifier = Modifier) {

}

@Composable
fun MainProfileApp(modifier: Modifier = Modifier) {
    Column {
        Column(
            modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            DataProfile(name = "My Person", icon = Icons.Outlined.Person)
            DataProfile(name = "Messages", icon = Icons.Outlined.Email)
            DataProfile(name = "Favourites", icon = Icons.Outlined.Favorite)
            DataProfile(name = "Location", icon = Icons.Outlined.LocationOn)
            DataProfile(name = "Settings", icon = Icons.Outlined.Settings)
        }
        HorizontalDivider(thickness = 2.dp)
        Column(
            modifier.fillMaxWidth()
        ) {
            LogoutProfile(name = "Logout", icon = Icons.Filled.ExitToApp)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MainProfileData() {
    MarketTheme {
        MainProfileApp()
    }
}

@Composable
fun DataProfile(
    name: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
){
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary,
        )
        Spacer(modifier = modifier.padding(16.dp))
        Text(text = name)
    }

}


@Composable
fun LogoutProfile(
    name: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
){
    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVerticallygit,
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary,
        )
        Spacer(modifier = modifier.padding(16.dp))
        Text(text = name)
    }

}