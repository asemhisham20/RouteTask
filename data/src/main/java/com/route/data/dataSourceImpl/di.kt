package com.route.data.dataSourceImpl


import com.route.data.dataSourceContract.ProductDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class di {



    @Binds
    abstract fun bindFavouritePiecesDataSource(productsDataSourceImpl: ProductsDataSourceImpl)
    : ProductDataSource


}