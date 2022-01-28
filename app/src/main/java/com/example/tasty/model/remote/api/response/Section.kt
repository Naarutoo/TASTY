package com.example.tasty.model.remote.api.response

data class Section(
    val components: List<Component>,
    val name: Any,
    val position: Int
)