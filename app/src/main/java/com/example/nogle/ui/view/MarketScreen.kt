package com.example.nogle.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.nogle.ui.MainViewModel

// I can click tab A to view a market list with name and price on each item and sorted by name
@Composable
fun MarketScreen(viewModel: MainViewModel) {
    val data by viewModel.marketLivedata.observeAsState(initial = emptyList())
    MarketList(marketList = data.sortedBy { it.marketName })
}
