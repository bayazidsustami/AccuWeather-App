package com.example.weatherapp.presentation.ui.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.weatherapp.domain.model.HistoryWeatherModel
import com.example.weatherapp.presentation.ui.theme.WeatherAppTheme

@Composable
fun WeatherHistory(
    modifier: Modifier = Modifier,
    data: List<HistoryWeatherModel>
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Weather History",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(12.dp)
        )
        Divider(Modifier.padding(start = 12.dp, end = 12.dp))
        WeatherInfoTable(
            data = data
        )
    }
}

@Composable
fun WeatherInfoTable(
    modifier: Modifier = Modifier,
    data: List<HistoryWeatherModel>
) {
    val horizontalScrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        HeaderTable(
            scrollState = horizontalScrollState,
        )
        Divider()
        Spacer(Modifier.padding(10.dp))
        data.forEachIndexed { index, value ->
            TableItem(
                scrollState = horizontalScrollState,
                index = index,
                data = value
            )
            Spacer(Modifier.padding(10.dp))
        }
    }
}

@Composable
fun TableItem(
    modifier: Modifier = Modifier,
    scrollState: ScrollState,
    index: Int,
    data: HistoryWeatherModel
) {
    val heightHeader = 24.dp
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .horizontalScroll(scrollState),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "${index + 1}",
                modifier = Modifier.size(60.dp, heightHeader),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = data.dateTime,
                modifier = Modifier.size(100.dp, heightHeader),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
            )
            Text(
                text = "${data.temperature.value} ℃",
                modifier = Modifier.size(130.dp, heightHeader),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )
            Text(
                text = data.iconPhrase,
                modifier = Modifier.size(80.dp, heightHeader),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            AsyncImage(
                model = data.getUrlIcon(),
                contentDescription = null,
                modifier = Modifier
                    .width(80.dp)
                    .height(50.dp)
                    .aspectRatio(1f / 1f)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun WeatherHistoryPreview(){
    WeatherAppTheme {
        WeatherHistory(
            data = emptyList()
        )
    }
}