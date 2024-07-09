package com.example.market.screen.profile

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.shape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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
import com.example.market.R
import com.example.market.component.BottomBar
import com.example.market.ui.theme.MarketTheme

@Composable
fun PersonScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(16.dp),


    ) {
        Text(
            text = "PEOPLE SETTINGS",
            fontWeight = FontWeight.SemiBold,
            modifier = modifier.padding(16.dp))
        ProfileDataScreen()
        Card(
            modifier = modifier
                .padding(8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(Color.Transparent)
        ) {
            Text(text = "General", modifier.padding(start = 16.dp), color = Color.Gray)
            MainGeneralScreen()

        }

        Card(
            modifier = modifier
                .padding(8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(Color.Transparent)
        ) {
            Text(text = "Performance", modifier.padding(start = 16.dp), color = Color.Gray)
            MainPerformaceScreen()

        }


    }
}


@Composable
fun ProfileDataScreen(
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.xukai1),
                contentDescription = "",
                modifier = modifier
                    .padding(8.dp)
                    .clip(CircleShape)
                    .size(60.dp)
            )
            Column {
                Text(text = "Xu Kai", fontSize = 20.sp, fontWeight = FontWeight.Medium)
                Text(text = "xukai@douyin.co.ch", fontSize = 16.sp, color = Color.Gray)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PersonScreenPreview() {
    MarketTheme {
        val navController = rememberNavController()
        PersonScreen(navController = navController)
//        ProfileDataScreen()


    }
}

