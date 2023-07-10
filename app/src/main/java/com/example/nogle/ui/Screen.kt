package com.example.nogle.ui

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Abc
import androidx.compose.material.icons.filled.Accessible
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.nogle.R

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
    val imageVector: ImageVector
) {
    object A : Screen("a", R.string.title_market, Icons.Filled.Abc)
    object B : Screen("b", R.string.title_spot, Icons.Filled.Accessible)
    object C : Screen("c", R.string.title_future, Icons.Filled.Favorite)
    object D : Screen("d", R.string.title_settings, Icons.Filled.Settings)
    object Settings : Screen("settings", R.string.title_settings, Icons.Filled.Settings)
}
