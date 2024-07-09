package com.example.market.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.market.model.list.ListPersonlPP


@Composable
fun ComponentPPScreen(modifier: Modifier = Modifier, listPersonlPP: ListPersonlPP) {
    Column(
        modifier = modifier
            .fillMaxWidth(),

//        colors = CardDefaults.cardColors(Color.Transparent)
    ) {


        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            Icon(
                imageVector = listPersonlPP.icon,
                contentDescription = listPersonlPP.textSmall,
                modifier = modifier
                    .padding(8.dp)
                    .clip(CircleShape)
                    .size(25.dp)
            )
            Column {
                Text(
                    text = listPersonlPP.textLarge,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(text = listPersonlPP.textSmall, fontSize = 9.sp, color = Color.Gray)
            }
        }

    }
}