package com.example.market.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.market.R
import com.example.market.model.ListBanner
import com.example.market.ui.theme.MarketTheme

@Composable
fun MainCardCategory(modifier: Modifier = Modifier, listBanner: ListBanner) {
    Card(modifier =
    modifier.width(175.dp)
        .padding(start = 16.dp, end = 16.dp)
        .heightIn(48.dp),
        shape = RoundedCornerShape(8.dp)) {
        Image(
            modifier = modifier.width(200.dp),
            painter = painterResource(id = listBanner.imgBanner), contentDescription = null)
    }
}

@Preview(showBackground = true)
@Composable
fun MainCardCategoryPreview() {
    MarketTheme {
        MainCardCategory(listBanner = ListBanner(R.drawable.banner1))
    }
}