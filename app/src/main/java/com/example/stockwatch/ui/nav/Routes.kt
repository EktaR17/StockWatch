package com.example.stockwatch.ui.nav

import kotlinx.serialization.Serializable

// ui/nav/Routes.kt
@Serializable
data object WatchlistRoute

@Serializable
data class DetailRoute(val symbol: String)