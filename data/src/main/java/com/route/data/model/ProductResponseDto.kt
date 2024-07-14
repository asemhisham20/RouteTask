package com.route.data.model

import com.google.gson.annotations.SerializedName
import com.route.domain.model.ProductResponse

data class ProductResponseDto(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("limit")
	val limit: Int? = null,

	@field:SerializedName("skip")
	val skip: Int? = null,

	@field:SerializedName("products")
	val products: List<ProductsItemDto?>? = null
){
	fun toProductResponse(): ProductResponse {
		return ProductResponse(
			total,
			limit,
			skip,
			products?.map { it?.toProductItem() }

		)
	}
}