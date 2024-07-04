package com.example.market

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.market.component.MainBottomCategory
import com.example.market.component.MainCardCategory
import com.example.market.component.MainTopBar
import com.example.market.component.MainTopCategory
import com.example.market.component.TopMenu
import com.example.market.model.dummyListBanner
import com.example.market.model.dummyListTopMenus
import com.example.market.model.dummyListBottomCategory
import com.example.market.model.dummyListTopCategory
import com.example.market.ui.theme.MarketTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MarketTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MarketApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MarketApp(modifier : Modifier= Modifier) {
    Column(modifier = modifier
        .verticalScroll(rememberScrollState())) {

        MainTopBar()
        MainTopMenu()
        MainCategoryTop()
        MainCategoryCard()
        MainCategoryBottom()
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
fun MainTopCategoryPreview() {
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MarketTheme {
        MarketApp()
    }
}