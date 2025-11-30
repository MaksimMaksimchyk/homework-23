package com.example.homework_23.data

import com.example.homework_23.domain.ProductModel
import com.example.homework_23.domain.ProductsRepository

class ProductsRepositoryImpl(private val localProductsDataSource: LocalProductsDataSource) :
    ProductsRepository {

    override fun getProducts(): List<ProductModel> {
        return localProductsDataSource.getProducts()
    }

    override fun addProduct(product: ProductModel) {
        localProductsDataSource.addProduct(product)
    }

    override fun deleteProduct(id: Long) {
        localProductsDataSource.deleteProduct(id)
    }

    override fun setPurchaseStatusToTrue(id: Long) {
        localProductsDataSource.setPurchaseStatusToTrue(id)
    }

    override fun setPurchaseStatusToFalse(id: Long) {
        localProductsDataSource.setPurchaseStatusToFalse(id)
    }
}