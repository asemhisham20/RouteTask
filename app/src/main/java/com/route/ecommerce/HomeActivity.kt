package com.route.ecommerce

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.facebook.shimmer.Shimmer
import com.google.android.material.snackbar.Snackbar
import com.route.ecommerce.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var viewBinding:ActivityHomeBinding
    lateinit var viewModel: HomeViewModel
    private val productRecyclerAdapter = ProductRecyclerAdapter(mutableListOf())
    var position: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
        getAllproducts()
        }

    private fun initViews() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewBinding.content.productRec.adapter = productRecyclerAdapter
    }

    override fun onStart() {
        super.onStart()
        viewBinding.content.retryBtn.setOnClickListener {
            viewModel.getProductData()
        }
        observeLiveData()
        getAllproducts()
    }

    private fun getAllproducts() {
        viewModel.getProductData()
    }



    private fun observeLiveData() {
        viewModel.productData.observe(this) {
            viewBinding.content.successContent.isVisible = true
            viewBinding.content.failedContent.isVisible = false

            productRecyclerAdapter.bindProductList(it?.products?.toMutableList())
        }

        viewModel.responseLiveData.observe(this) {
            productRecyclerAdapter.binditem(it!!, position!!)
            Log.e("asem", "a7a")
        }

        viewModel.loadingLiveData.observe(this) {
            if (it) {
                showShimmer()
            } else {
                hideShimmer()
            }
        }
        viewModel.error.observe(this) {
            viewBinding.content.successContent.isVisible = false
            viewBinding.content.failedContent.isVisible = true
            Snackbar.make(
                this,
                viewBinding.root,
                "حدث مشكلة اثناء الاتصال حاول مرة اخرى",
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    private fun showShimmer() {
        val shimmer = Shimmer
            .AlphaHighlightBuilder()
            .setAutoStart(true)
            .setBaseAlpha(0.25f)
            .setHighlightAlpha(0.50f)
            .setDropoff(50f)
            .setDirection(Shimmer.Direction.TOP_TO_BOTTOM)
            .build()
        viewBinding.content.shimmer.setShimmer(shimmer)
        viewBinding.content.shimmer.startShimmer()
        viewBinding.content.shimmer.isVisible = true
        viewBinding.content.failedContent.isVisible = false
        viewBinding.content.successContent.isVisible = false


    }

    private fun hideShimmer() {
        viewBinding.content.shimmer.stopShimmer()
        viewBinding.content.shimmer.isVisible = false
    }
}