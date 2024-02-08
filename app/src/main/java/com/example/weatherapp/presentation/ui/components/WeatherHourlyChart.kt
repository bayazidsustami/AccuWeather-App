package com.example.weatherapp.presentation.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.domain.model.HourlyWeatherModel
import com.example.weatherapp.domain.model.ValueUnit
import com.example.weatherapp.presentation.ui.theme.WeatherAppTheme
import com.patrykandpatrick.vico.compose.axis.axisLabelComponent
import com.patrykandpatrick.vico.compose.axis.horizontal.rememberBottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.rememberStartAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.column.columnChart
import com.patrykandpatrick.vico.compose.m3.style.m3ChartStyle
import com.patrykandpatrick.vico.compose.style.ProvideChartStyle
import com.patrykandpatrick.vico.core.axis.AxisPosition
import com.patrykandpatrick.vico.core.axis.formatter.AxisValueFormatter
import com.patrykandpatrick.vico.core.component.OverlayingComponent
import com.patrykandpatrick.vico.core.component.shape.LineComponent
import com.patrykandpatrick.vico.core.entry.ChartEntryModel
import com.patrykandpatrick.vico.core.entry.ChartEntryModelProducer
import com.patrykandpatrick.vico.core.entry.entryOf

@Composable
fun WeatherHourlyChart(
    modifier: Modifier = Modifier,
    data: List<HourlyWeatherModel> = emptyList()
) {

    val entryData = entryWeatherModelOf(data)

    val horizontalValueFormatter = AxisValueFormatter<AxisPosition.Horizontal.Bottom> { value, _ ->
        return@AxisValueFormatter "${(value + 1).toInt()}"
    }

    val verticalValueFormatter = AxisValueFormatter<AxisPosition.Vertical.Start> { value, _ ->
        val formattedValue = String.format("%.2f", value)
        return@AxisValueFormatter "$formattedValue ℃"
    }

    Card(
        modifier = modifier
            .padding(16.dp),
    ) {
        Text(
            text = "Hourly Forecast",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(12.dp)
        )
        Divider(Modifier.padding(start = 12.dp, end = 12.dp))
        ProvideChartStyle(
            chartStyle = m3ChartStyle(
                axisLabelColor = MaterialTheme.colorScheme.secondary,
                axisGuidelineColor = MaterialTheme.colorScheme.primary,
                axisLineColor = MaterialTheme.colorScheme.secondary,
                elevationOverlayColor = MaterialTheme.colorScheme.secondary,
            )
        ) {
            Chart(
                chart = columnChart(),
                model = entryData,
                bottomAxis = rememberBottomAxis(
                    guideline = LineComponent(
                        color = R.color.purple_200,
                        thicknessDp = 0f,
                    ),
                    label = axisLabelComponent(
                        color = MaterialTheme.colorScheme.primary,
                    ),
                    valueFormatter = horizontalValueFormatter
                ),
                startAxis = rememberStartAxis(
                    guideline = LineComponent(
                        color = R.color.purple_200,
                        thicknessDp = 0f,
                    ),
                    labelRotationDegrees = 15f,
                    valueFormatter = verticalValueFormatter
                ),
                isZoomEnabled = true,
                modifier = Modifier
                    .padding(12.dp),
            )
        }
    }
}

fun entryWeatherModelOf(values: List<HourlyWeatherModel>): ChartEntryModel =
    values
        .mapIndexed { index, value -> entryOf(index, value.getCelsius()) }
        .let { entryList -> ChartEntryModelProducer(listOf(entryList)) }
        .requireModel()

@Preview(showSystemUi = true)
@Composable
fun WeatherHourlyChartPreview(){
    WeatherAppTheme {
        WeatherHourlyChart(
            data = listOf(
                HourlyWeatherModel(
                    temperature = ValueUnit(
                        value = 70.0,
                        unit = "C"
                    ),
                    dateTime = 1707375300,
                    iconPhrase = "clody",
                    weatherIcon = 2
                ),
                HourlyWeatherModel(
                    temperature = ValueUnit(
                        value = 80.0,
                        unit = "C"
                    ),
                    dateTime = 1707375300,
                    iconPhrase = "clody",
                    weatherIcon = 2
                ),
                HourlyWeatherModel(
                    temperature = ValueUnit(
                        value = 73.9,
                        unit = "C"
                    ),
                    dateTime = 1707375300,
                    iconPhrase = "clody",
                    weatherIcon = 2
                ),
                HourlyWeatherModel(
                    temperature = ValueUnit(
                        value = 60.9,
                        unit = "C"
                    ),
                    dateTime = 1707375300,
                    iconPhrase = "clody",
                    weatherIcon = 2
                ),
            )
        )
    }
}