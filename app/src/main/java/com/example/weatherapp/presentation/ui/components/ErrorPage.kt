package com.example.weatherapp.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.presentation.ui.theme.WeatherAppTheme

@Composable
fun ErrorPage(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier
                .size(256.dp)
                .align(Alignment.Center),
            painter = painterResource(R.drawable.something_wrong),
            contentDescription = null
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun ErrorPagePreview(){
    WeatherAppTheme {
        ErrorPage()
    }
}