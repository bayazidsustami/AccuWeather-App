package com.example.weatherapp.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.example.weatherapp.domain.model.CurrentWeatherModel
import com.example.weatherapp.presentation.ui.theme.WeatherAppTheme

@Composable
fun HomeMainWeatherInfo(
    modifier: Modifier = Modifier,
    data: CurrentWeatherModel
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
            WeatherTemperatureLabel(
                data = data
            )
            Divider(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp)
            )
            DetailWeather(
                data = data
            )
        }
    }
}

@Composable
fun WeatherTemperatureLabel(
    modifier: Modifier = Modifier,
    data: CurrentWeatherModel
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column {
            Row {
                Text(
                    text = "${data.currentTemp}",
                    fontSize = 70.sp,
                )
                Text(
                    text = "\u2103",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .padding(top = 16.dp)
                )
            }
            Text(
                text = data.currentTempName,
                style = MaterialTheme.typography.titleMedium
            )
        }
        AsyncImage(
            model = data.getUrlIcon(),
            contentDescription = "weather icon",
            modifier = Modifier
                .width(100.dp)
                .aspectRatio(1f/1f)
        )
    }
}

@Composable
fun DetailWeather(
    modifier: Modifier = Modifier,
    data: CurrentWeatherModel
) {
    Column(
        modifier = modifier,
    ) {
        HorizontalPairText(textPair = Pair("Wind Gusts", "${data.windGust.value} ${data.windGust.unit}"))
        HorizontalPairText(textPair = Pair("Humidity", "${data.humidity.value}${data.humidity.unit}"))
        HorizontalPairText(textPair = Pair("Indoor Humidity", "${data.indoorHumidity.value}${data.humidity.unit}"))
        HorizontalPairText(textPair = Pair("Dew Point", "${data.dewPoint.value} ${data.dewPoint.unit}"))
        HorizontalPairText(textPair = Pair("Pressure", "${data.pressure.value} ${data.pressure.unit}"))
        HorizontalPairText(textPair = Pair("Cloud Cover", "${data.cloudCover.value}${data.cloudCover.unit}"))
        HorizontalPairText(textPair = Pair("Visibility", "${data.visibility.value} ${data.visibility.unit}"))
        HorizontalPairText(textPair = Pair("Cloud Ceiling", "${data.cloudCeiling.value} ${data.cloudCeiling.unit}"))
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeMainWeatherInfoPreview(){
    WeatherAppTheme {
    }
}