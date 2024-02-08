package com.example.weatherapp.domain.model

data class ValueUnit<out V, U>(
    val value: V,
    val unit: U
)