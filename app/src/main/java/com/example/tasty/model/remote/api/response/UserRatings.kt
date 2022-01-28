package com.example.tasty.model.remote.api.response

data class UserRatings(
    val count_negative: Int,
    val count_positive: Int,
    val score: Double
)