package com.example.weatherapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun HorizontalPairText(
    modifier: Modifier = Modifier,
    textPair: Pair<String, String>
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = textPair.first,
            style = MaterialTheme.typography.labelLarge
        )
        Text(
            text = textPair.second,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun HorizontalPairTextPreview() {
    WeatherAppTheme {
        HorizontalPairText(
            textPair = Pair("Wind Gusts", "7 km/h")
        )
    }
}