package com.example.nogle.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nogle.ui.MainViewModel

// Use parameter symbol to display name
@Composable
fun SpotScreen(viewModel: MainViewModel, navController: NavController) {
    val data by viewModel.marketLivedata.observeAsState(initial = emptyList())

    val options = listOf("Spot", "Future")
    var selectedOption by remember { mutableStateOf("Spot") }
    val onSelectionChange = { text: String ->
        selectedOption = text
    }

    Column {
        TopAppBar(
            elevation = 4.dp,
            title = {
                Box(
                    Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Spot",
                        fontSize = 30.sp,
                    )
                }
            },
            backgroundColor = MaterialTheme.colors.primarySurface,
            modifier = Modifier.fillMaxWidth()
        )
        Row() {
            options.forEach { text ->
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = text,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1.merge(),
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onSelectionChange(text)
                                if (text == "Spot") {
                                    navController.navigate("b")
                                } else {
                                    navController.navigate("c")
                                }
                            }
                            .background(
                                if (text == selectedOption) {
                                    Color.Magenta
                                } else {
                                    Color.LightGray
                                }
                            )
                            .padding(vertical = 12.dp, horizontal = 16.dp),
                    )
                }
            }
        }
        MarketList(marketList = data.sortedBy { it.symbol })
    }
}