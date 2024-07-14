package com.route.data.dataSourceContract

import com.route.domain.model.ProductResponse

interface ProductDataSource {
    suspend fun getProducts(): ProductResponse?
}