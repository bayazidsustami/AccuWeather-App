package com.example.weatherapp.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherapp.ui.theme.WeatherAppTheme
import com.patrykandpatrick.vico.compose.axis.horizontal.rememberBottomAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.line.lineChart
import com.patrykandpatrick.vico.core.entry.entryModelOf

@Composable
fun WeatherHourlyChart(
    modifier: Modifier = Modifier
) {
    val chartEntryModel = entryModelOf(4f, 5f, 8f, 16f)

    Chart(
        chart = lineChart(),
        model = chartEntryModel,
        bottomAxis = rememberBottomAxis(),
        modifier = modifier
    )
}

@Preview(showSystemUi = true)
@Composable
fun WeatherHourlyChartPreview(){
    WeatherAppTheme {
        WeatherHourlyChart()
    }
}