package com.example.stockwatch.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun AppNavHost() {
    val nav = rememberNavController()
    NavHost(nav, startDestination = WatchlistRoute) {
        composable<WatchlistRoute> {
            WatchlistScreenRoute(onOpen = { symbol -> nav.navigate(DetailRoute(symbol)) })
        }
        composable<DetailRoute> { entry ->
            val args = entry.toRoute<DetailRoute>()
            DetailScreen(symbol = args.symbol, onBack = { nav.popBackStack() })
        }
    }
}