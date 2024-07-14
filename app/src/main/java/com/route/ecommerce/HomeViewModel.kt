package com.route.ecommerce

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.domain.model.ProductResponse
import com.route.domain.model.productItem
import com.route.domain.useCase.ProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getproductUseCase: ProductsUseCase,

    ) : ViewModel() {
  val productData = MutableLiveData<ProductResponse?>()
  val loadingLiveData = MutableLiveData<Boolean>()
    val responseLiveData = MutableLiveData<productItem?>()
    val error = MutableLiveData<String>()
    fun getProductData() {
        viewModelScope.launch {
            loadingLiveData.postValue(true)
            try {

                val result = getproductUseCase.getFavouriteMuseums()
                productData.postValue(result)
                Log.e("list", result.toString())
            } catch (e: Exception) {
                error.postValue(e.localizedMessage)
                Log.e("list", e.localizedMessage!!)
            } finally {
                loadingLiveData.postValue(false)
            }
        }
    }
}