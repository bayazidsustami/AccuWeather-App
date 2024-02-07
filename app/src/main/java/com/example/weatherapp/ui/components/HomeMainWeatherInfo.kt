package com.example.weatherapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun HomeMainWeatherInfo(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(
                text = "Current Weather",
                style = MaterialTheme.typography.titleMedium
            )
            Divider(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp)
            )
            WeatherTemperatureLabel()
            Divider(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp)
            )
            DetailWeather()
        }
    }
}

@Composable
fun WeatherTemperatureLabel(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column {
            Text(
                text = "25 \u2103",
                fontSize = 70.sp,
                modifier = Modifier
            )
            Text(
                text = "Cloudy",
                style = MaterialTheme.typography.labelLarge
            )
        }
        AsyncImage(
            model = "https://developer.accuweather.com/sites/default/files/01-s.png",
            contentDescription = "weather icon",
            modifier = Modifier
                .size(120.dp)
        )
    }
}

@Composable
fun DetailWeather(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
    ) {
        HorizontalPairText(textPair = Pair("Wind Gusts", "7 km/h"))
        HorizontalPairText(textPair = Pair("Humidity", "100%"))
        HorizontalPairText(textPair = Pair("Indoor Humidity", "95% (Extremely Humid)"))
        HorizontalPairText(textPair = Pair("Dew Point", "25° C"))
        HorizontalPairText(textPair = Pair("Pressure", "1011 mb"))
        HorizontalPairText(textPair = Pair("Cloud Cover", "45%"))
        HorizontalPairText(textPair = Pair("Visibility", "8 km"))
        HorizontalPairText(textPair = Pair("Cloud Ceiling", "12200 m"))
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeMainWeatherInfoPreview(){
    WeatherAppTheme {
        HomeMainWeatherInfo()
    }
}