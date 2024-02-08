package com.example.weatherapp.presentation.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.InfiniteTransition
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import com.example.weatherapp.presentation.ui.theme.ShimmerColorShades

@Composable
fun ShimmerView(
    modifier: Modifier = Modifier,
    transition: InfiniteTransition = rememberInfiniteTransition(label = "shimmer"),
) {
    val translateAnimation by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis = 1200,
                easing = FastOutSlowInEasing,
            ),
            repeatMode = RepeatMode.Reverse
        ), label = "shimmer"
    )

    val brush = Brush.linearGradient(
        colors = ShimmerColorShades,
        start = Offset(10f,10f),
        end = Offset(translateAnimation, translateAnimation)
    )

    Spacer(
        modifier = modifier
            .background(brush = brush)
    )
}
