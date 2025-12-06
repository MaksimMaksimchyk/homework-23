package com.example.homework_23.data

import com.example.homework_23.domain.ProductModel

class LocalProductsDataSource {

    private val products = mutableListOf<ProductModel>()
    fun getProducts(): List<ProductModel> = products.toList()

    fun addProduct(product: ProductModel) {
        products.add(0, product)
    }

    fun deleteProduct(productId: Long) {
        products.remove(products.find { it.id == productId })
    }

    fun setPurchaseStatusToTrue(productId: Long) {
        products.first() { it.id == productId }.purchased = true
    }

    fun setPurchaseStatusToFalse(productId: Long) {
        products.first() { it.id == productId }.purchased = false
    }

}