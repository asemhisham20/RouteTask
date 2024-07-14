package com.route.data.api




import com.route.data.model.ProductResponseDto
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query


interface
WebServices {

   @GET("products")
 suspend fun getProducts(
   ): ProductResponseDto



}