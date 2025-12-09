package com.example.homework_23.domain

interface ProductsRepository {
    fun getProducts(): List<ProductModel>
    fun addProduct(product: ProductModel)
    fun deleteProduct(id: Long)
    fun setPurchaseStatusToTrue(id: Long)
    fun setPurchaseStatusToFalse(id: Long)
}