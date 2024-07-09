package com.example.market.component

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.market.MainCategoryBottom
import com.example.market.MainCategoryCard
import com.example.market.MainCategoryTop
import com.example.market.MainTopMenu
import com.example.market.R
import com.example.market.model.list.ProfileIData
import com.example.market.ui.theme.MarketTheme
import kotlinx.coroutines.launch
import okhttp3.Route

@Composable
fun ProfileApp(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(bottomBar = { BottomBar(navController) }) { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {

            MainProfileApp(navController)

        }
    }
}
sealed class Screen(val route: String) {
    object MyPerson : Screen("my_person")
    object Messages : Screen("messages")
    object Favorites : Screen("favorites")
    object Location : Screen("location")
    object Settings : Screen("settings")
}

@Composable
fun MainProfileApp(navController: NavController,modifier: Modifier = Modifier) {
    Column {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
        ) {
            PhotoProfile(
                name = "Xu Kai",
                photoProfile = painterResource(id = R.drawable.xukai1),
                jobProfile = "Artist"
            )
        }
        Column(
            modifier
                .padding(16.dp, bottom = 48.dp, top = 48.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            DataProfile(
                name = "My Person",
                icon = Icons.Outlined.Person,
                onClick = { navController.navigate(Screen.MyPerson.route) }
            )
            DataProfile(
                name = "Messages",
                icon = Icons.Outlined.Email,
                onClick = { navController.navigate(Screen.Messages.route) }
            )
            DataProfile(
                name = "Favourites",
                icon = Icons.Outlined.Favorite,
                onClick = { navController.navigate(Screen.Favorites.route) }
            )
            DataProfile(
                name = "Location",
                icon = Icons.Outlined.LocationOn,
                onClick = { navController.navigate(Screen.Location.route) }
            )
            DataProfile(
                name = "Settings",
                icon = Icons.Outlined.Settings,
                onClick = { navController.navigate(Screen.Settings.route) }
            )


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
    val navController = rememberNavController()
    MarketTheme {
        MainProfileApp(navController = navController)
    }
}

@Composable
fun DataProfile(
    name: String,
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary,
        )
        Spacer(modifier = modifier.padding(16.dp))
        Text(text = name, color = Color.Gray)
    }

}


@Composable
fun LogoutProfile(
    name: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
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
fun PhotoProfile(
    name: String,
    photoProfile: Painter,
    jobProfile: String,
    modifier: Modifier = Modifier,
) {
    Image(
        painter = photoProfile, contentDescription = name,
        modifier
            .padding(8.dp)
            .clip(CircleShape)
            .size(100.dp),
    )
    Text(text = name, fontWeight = FontWeight.Medium)
    Text(text = jobProfile, fontSize = 13.sp, color = Color.Gray)
}

