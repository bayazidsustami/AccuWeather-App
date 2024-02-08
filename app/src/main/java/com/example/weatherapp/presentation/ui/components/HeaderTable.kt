package com.example.weatherapp.presentation.ui.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun HeaderTable(
    modifier: Modifier = Modifier,
    scrollState: ScrollState
) {
    val heightHeader = 24.dp
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .horizontalScroll(scrollState),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "No.",
            modifier = Modifier.size(60.dp, heightHeader),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "Date Time",
            modifier = Modifier.size(100.dp, heightHeader),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "Temperature",
            modifier = Modifier.size(130.dp, heightHeader),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "Text",
            modifier = Modifier.size(80.dp, heightHeader),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "Icon",
            modifier = Modifier.size(80.dp, heightHeader),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium
        )
    }
}