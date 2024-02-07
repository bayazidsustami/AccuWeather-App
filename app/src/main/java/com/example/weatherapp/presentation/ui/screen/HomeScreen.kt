package com.example.weatherapp.presentation.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherapp.presentation.ui.components.HomeHeader
import com.example.weatherapp.presentation.ui.components.HomeMainWeatherInfo
import com.example.weatherapp.presentation.ui.components.WeatherHourlyChart
import com.example.weatherapp.presentation.ui.theme.WeatherAppTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    HomeScreenContent(
        modifier = modifier
    )
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
        HomeMainWeatherInfo()
        WeatherHourlyChart()
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