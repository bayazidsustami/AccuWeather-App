package com.example.weatherapp.presentation.ui.screen

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.example.weatherapp.presentation.ui.components.HomeHeader
import com.example.weatherapp.presentation.ui.components.HomeMainWeatherInfo
import com.example.weatherapp.presentation.ui.components.WeatherHourlyChart
import com.example.weatherapp.presentation.ui.theme.WeatherAppTheme
import com.google.android.gms.location.LocationServices

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    var location by remember { mutableStateOf("") }
    val context = LocalContext.current
    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        onResult = {
            val isGranted = it.all { permission -> permission.value  }
            if (isGranted) {
                getCurrentLocation(context){ lat, lon ->
                    location = "$lat,$lon"
                }
            }
        }
    )

    LaunchedEffect(key1 = Unit,){
        if (hasLocationPermission(context)) {
            getCurrentLocation(context){ lat, lon ->
                location = "$lat,$lon"
            }
        } else {
            requestPermissionLauncher.launch(arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION)
            )
        }
    }

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

private fun hasLocationPermission(context: Context): Boolean {
    return ContextCompat.checkSelfPermission(
        context,
        Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
        context,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED
}

private fun getCurrentLocation(context: Context, callback: (Double, Double) -> Unit) {
    val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
    try {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                if (location != null) {
                    val lat = location.latitude
                    val long = location.longitude
                    callback(lat, long)
                }
            }
            .addOnFailureListener { exception ->
                exception.printStackTrace()
            }
    } catch (e: SecurityException) {
        e.printStackTrace()
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