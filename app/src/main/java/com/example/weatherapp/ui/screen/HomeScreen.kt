package com.example.weatherapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherapp.ui.components.HomeHeader
import com.example.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {

}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HomeHeader(location = "Antang")
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    WeatherAppTheme {
        HomeScreenContent()
    }
}