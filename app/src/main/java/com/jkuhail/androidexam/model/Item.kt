package com.jkuhail.androidexam.model

import androidx.annotation.DrawableRes

data class Item(
    @DrawableRes
    var thumb: Int,
    var title: String,
    var content: String
)
