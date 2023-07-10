package com.example.nogle.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nogle.model.Market

@Preview(showBackground = true)
@Composable
fun MarketList() {
    val marketList = listOf(
        Market(
            "market name",
            active = true,
            marketClosed = true,
            matchingDisabled = true,
            future = true,
            timeBasedContract = true,
            openTime = 1L,
            closeTime = 1L,
            startMatching = 1L,
            inactiveTime = 1L,
            sortId = 1,
            lastUpdate = 1L,
            symbol = "symbol",
            quoteCurrency = "quoteCurrency",
            baseCurrency = "baseCurrency",
            fundingRate = 1.1,
            openInterest = 1.1,
            openInterestUSD = 1.1,
            display = true,
            displayQuote = "displayQuote",
            globalDisplayQuote = "globalDisplayQuote",
            displayOrder = 1,
            isFavorite = true,
            initialMarginPercentage = 1.1,
            maintenanceMarginPercentage = 1.1,
            prediction = true,
            availableQuotes = listOf()
        )
    )
    MarketList(marketList)
}

@Composable
fun MarketList(marketList: List<Market>) {
    LazyColumn {
        itemsIndexed(items = marketList) { _, item ->
            MarketItem(name = item.symbol, price = item.openInterest.toString())
        }
    }
}

@Composable
fun MarketItem(name: String, price: String) {

    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Row(
            Modifier
                .padding(4.dp)
                .fillMaxSize()
        ) {
            Column() {
                Text(
                    text = "Name: ",
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.h2,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = name,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold,
                )
            }

            Spacer(modifier = Modifier.weight(1.0f))

            Column() {
                Text(
                    text = "Price: ",
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.h2,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = price,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End,
                )
            }
        }
    }
}