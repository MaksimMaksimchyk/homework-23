package com.example.homework_23.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework_23.data.LocalProductsDataSource
import com.example.homework_23.data.ProductsRepositoryImpl
import com.example.homework_23.domain.ProductModel
import com.example.homework_23.domain.ProductsInteractor

class MainActivityViewModel : ViewModel() {
    private val _products = MutableLiveData<List<ProductModel>>()
    val products: LiveData<List<ProductModel>> = _products

    private val productsInteractor: ProductsInteractor by lazy {
        val dataSource = LocalProductsDataSource()
        val repository = ProductsRepositoryImpl(dataSource)
        ProductsInteractor(repository)
    }

    init {
        loadProducts()
    }

    fun loadProducts() {
        val productsList = productsInteractor.getProducts()
        _products.value = productsList
    }

    fun addProduct(name: String) {
        if (name.isBlank()) return
        productsInteractor.addProduct(name)
        loadProducts()
    }

    fun deleteProduct(product: ProductModel) {
        productsInteractor.deleteProduct(product.id)
        loadProducts()
    }

    fun changePurchaseStatus(product: ProductModel) {
        productsInteractor.changePurchaseStatus(product)
        loadProducts()
    }

}