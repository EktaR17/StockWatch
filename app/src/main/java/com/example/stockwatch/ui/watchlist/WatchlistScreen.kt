package com.example.stockwatch.ui.watchlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun WatchlistScreenRoute(onOpen: (String) -> Unit, vm: WatchlistViewModel = hiltViewModel()) {
    val symbols by vm.symbols.collectAsStateWithLifecycle()
    WatchlistScreen(symbols, onOpen)
}

@Composable
fun WatchlistScreen(symbols: List<String>, onOpen: (String) -> Unit) {
    Scaffold { padding ->
        LazyColumn(Modifier.padding(padding), contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(symbols, key = { it }) { s ->
                Card(Modifier.fillMaxWidth().clickable { onOpen(s) }) {
                    Text(s, Modifier.padding(16.dp), style = MaterialTheme.typography.titleMedium)
                }
            }
        }
    }
}

