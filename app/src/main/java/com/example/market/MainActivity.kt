package com.example.market

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.market.component.BottomBar
import com.example.market.component.MainBannerVertical
import com.example.market.component.MainBottomCategory
import com.example.market.component.MainCardCategory
import com.example.market.component.MainImageCategory
import com.example.market.component.MainTopBar
import com.example.market.component.MainTopCategory
import com.example.market.component.ProfileApp
import com.example.market.component.Screen
import com.example.market.component.TopMenu
import com.example.market.model.list.dummyListBanner
import com.example.market.model.list.dummyListTopMenus
import com.example.market.model.list.dummyListBottomCategory
import com.example.market.model.list.dummyListCardVertikal
import com.example.market.model.list.dummyListTopCategory
import com.example.market.screen.profile.FavoritesScreen
import com.example.market.screen.profile.LocationScreen
import com.example.market.screen.profile.MessagesScreen
import com.example.market.screen.profile.MyPersonScreen
import com.example.market.screen.profile.SettingsScreen
import com.example.market.screen.login.LoginScreen
import com.example.market.ui.theme.MarketTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MarketTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
////                    MarketApp(
////                        modifier = Modifier.padding(innerPadding)
////                    )
//                    ImageApp(
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }

                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "login"){
                    composable("login"){ LoginScreen(navController)}
                    composable("marketapp"){ MarketApp(navController)}
                    composable("list"){ ImageApp(navController) }
                    composable("profile"){ ProfileApp(navController) }
                    composable(Screen.MyPerson.route) { MyPersonScreen(navController) }
                    composable(Screen.Messages.route) { MessagesScreen(navController) }
                    composable(Screen.Favorites.route) { FavoritesScreen(navController) }
                    composable(Screen.Location.route) { LocationScreen(navController) }
                    composable(Screen.Settings.route) { SettingsScreen(navController) }
                }

            }
        }
    }
}



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MarketApp(navController: NavController, modifier : Modifier= Modifier) {
    Scaffold(
        bottomBar = { BottomBar(navController)}
    ) {paddingValues ->
        Column(modifier = modifier
            .padding(paddingValues)
            .verticalScroll(rememberScrollState())) {

            MainTopBar()
            MainTopMenu()
            MainCategoryTop()
            MainCategoryCard()
            MainCategoryBottom()
            MainImageCategory()
            MainBannerVertical()
        }
    }

}

@Composable
fun MainBannerVertical(){
    LazyRow(
        horizontalArrangement = Arrangement.Start
    ) {
        items(dummyListCardVertikal){
            MainBannerVertical(listBannerVertikal =  it)
        }

    }
}



@Composable
fun MainTopMenu(){
    LazyRow (
        horizontalArrangement = Arrangement.Start
    ){
        items(dummyListTopMenus){
            TopMenu(listTopMenu = it)
        }
    }
}


@Composable
fun MainCategoryTop(){
    LazyRow(
        horizontalArrangement = Arrangement.Start
    ) {
        items(dummyListTopCategory){
            MainTopCategory(listTopCategory = it)
        }
    }
}

@Composable
fun MainCategoryBottom(){
    LazyRow(
        horizontalArrangement = Arrangement.Start
    ) {
        items(dummyListBottomCategory){
            MainBottomCategory(listBottomCategory = it)
        }
    }
}
@Composable
fun MainCategoryCard(){
    LazyRow {
        items(dummyListBanner){
            MainCardCategory(listBanner = it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainBottomCategoryPreview() {
    MarketTheme {
        MainCategoryBottom()
    }
}


@Preview(showBackground = true)
@Composable
fun MarketAppPreview() {
    MarketTheme {
        MainCategoryTop()
    }
}

@Preview(showBackground = true)
@Composable
fun MainTopMenuPreview() {
    MarketTheme {
        MainTopMenu()
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MarketTheme {
//        MarketApp()
//    }
//}