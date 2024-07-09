package com.example.market.screen.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.market.component.ComponentPPScreen
import com.example.market.model.list.ListPersonlPP
import com.example.market.model.list.dummyGeneralPP
import com.example.market.model.list.dummyPerformacePP
import com.example.market.ui.theme.MarketTheme


@Composable
fun MainGeneralScreen() {
    LazyColumn {
        items(dummyGeneralPP) {
            ComponentPPScreen(listPersonlPP = it)
        }
    }
}

@Composable
fun MainPerformaceScreen() {
    LazyColumn {
        items(dummyPerformacePP) {
            ComponentPPScreen(listPersonlPP = it)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GeneralScreenPreview() {
    MarketTheme {
//        val navController = rememberNavController()
//        PersonScreen(navController = navController)

        ComponentPPScreen(listPersonlPP = ListPersonlPP(
            Icons.Filled.Person, "Edit Profile", "Change Your Profile"

        ))
    }
}