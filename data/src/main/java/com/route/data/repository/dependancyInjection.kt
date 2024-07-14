package com.route.data.repository

import com.route.domain.repositories.ProductRepository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class dependancyInjection {

    @Binds
    abstract fun bindproductRepository(productRepositoryImpl: ProductRepositoryImpl) :ProductRepository


}