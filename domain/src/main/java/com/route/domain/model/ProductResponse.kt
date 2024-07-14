package com.route.domain.model

data class ProductResponse(

    val total: Int? = null,

    val limit: Int? = null,

    val skip: Int? = null,

    val products: List<productItem?>? = null
)
