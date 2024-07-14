package com.route.domain.useCase

import com.route.domain.model.ProductResponse
import com.route.domain.repositories.ProductRepository
import javax.inject.Inject

class ProductsUseCase  @Inject constructor(
    private  val productRepository: ProductRepository

    ) {
    suspend fun getFavouriteMuseums(): ProductResponse? {
        return productRepository.getProducts()
    }

}