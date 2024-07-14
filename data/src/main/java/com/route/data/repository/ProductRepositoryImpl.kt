package com.route.data.repository

import com.route.data.dataSourceContract.ProductDataSource
import com.route.domain.model.ProductResponse
import com.route.domain.repositories.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDataSource:ProductDataSource
) :ProductRepository {
    override suspend fun getProducts(): ProductResponse? {
        return productDataSource.getProducts()
    }
}