package com.example.tasty.model.remote.api.response

data class InstructionX(
    val appliance: Any,
    val display_text: String,
    val end_time: Int,
    val id: Int,
    val position: Int,
    val start_time: Int,
    val temperature: Any
)