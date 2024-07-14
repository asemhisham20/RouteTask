package com.route.data.dataSourceImpl

import com.route.data.api.WebServices
import com.route.data.dataSourceContract.ProductDataSource
import com.route.domain.model.ProductResponse
import javax.inject.Inject

class ProductsDataSourceImpl @Inject constructor(
    private val webServices: WebServices
) : ProductDataSource{
    override suspend fun getProducts(): ProductResponse? {
return webServices.getProducts().toProductResponse()
    }
}