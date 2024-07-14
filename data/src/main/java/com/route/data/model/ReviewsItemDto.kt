package com.route.data.model

import com.google.gson.annotations.SerializedName
import com.route.domain.model.reviewsItem

data class ReviewsItemDto(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("reviewerName")
	val reviewerName: String? = null,

	@field:SerializedName("reviewerEmail")
	val reviewerEmail: String? = null,

	@field:SerializedName("rating")
	val rating: Int? = null,

	@field:SerializedName("comment")
	val comment: String? = null
) {
	fun toReviewsItem(): reviewsItem {
		return reviewsItem(
			date, reviewerName, reviewerEmail, rating, comment
		)
	}
}