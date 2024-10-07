package com.example.newsapp.presentation.screens.onboarding.model

import androidx.annotation.DrawableRes
import com.example.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)


val pages = listOf(

    Page(
        title = "The News App is a modern mobile ",
        description = "The News App is a modern mobile ",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "The News App is a modern mobile ",
        description = "The News App is a modern mobile ",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "The News App is a modern mobile ",
        description = "The News App is a modern mobile",
        image = R.drawable.onboarding3
    )

)