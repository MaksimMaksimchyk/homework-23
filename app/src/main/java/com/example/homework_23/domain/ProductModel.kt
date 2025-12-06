package com.example.homework_23.domain

data class ProductModel(
    val id: Long = System.currentTimeMillis(),
    val name: String,
    var purchased: Boolean = false
)