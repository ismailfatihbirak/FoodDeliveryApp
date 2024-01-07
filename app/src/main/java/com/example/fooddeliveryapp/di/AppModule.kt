package com.example.fooddeliveryapp.di

import com.example.fooddeliveryapp.data.datasource.DataSource
import com.example.fooddeliveryapp.data.repository.Repository
import com.example.fooddeliveryapp.retrofit.ApiUtils
import com.example.fooddeliveryapp.retrofit.FoodDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideFoodRepository(fds:DataSource) : Repository{
        return Repository(fds)
    }

    @Provides
    @Singleton
    fun provideFoodDataSource(fdao:FoodDao) : DataSource{
        return DataSource(fdao)
    }

    @Provides
    @Singleton
    fun provideFoodDao() : FoodDao {
        return ApiUtils.getFoodDao()
    }

}