package com.route.domain.repositories

import com.route.domain.model.ProductResponse

interface ProductRepository {
    suspend fun getProducts():ProductResponse?
}