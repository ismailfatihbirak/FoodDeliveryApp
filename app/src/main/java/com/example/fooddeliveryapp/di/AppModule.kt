package com.example.fooddeliveryapp.di

import android.content.Context
import androidx.room.Room
import com.example.fooddeliveryapp.data.datasource.DataSource
import com.example.fooddeliveryapp.data.datasource.RoomDataSource
import com.example.fooddeliveryapp.data.repository.Repository
import com.example.fooddeliveryapp.data.repository.RoomRepository
import com.example.fooddeliveryapp.retrofit.ApiUtils
import com.example.fooddeliveryapp.retrofit.FoodDao
import com.example.fooddeliveryapp.room.RoomDao
import com.example.fooddeliveryapp.room.RoomVeritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Provides
    @Singleton
    fun provideRoomRepository(rds:RoomDataSource) : RoomRepository{
        return RoomRepository(rds)
    }
    @Provides
    @Singleton
    fun provideRoomDataSource(rdao:RoomDao) : RoomDataSource{
        return RoomDataSource(rdao)
    }

    @Provides
    @Singleton
    fun provideRoomDao(@ApplicationContext context: Context) : RoomDao {
        val vt = Room.databaseBuilder(context,RoomVeritabani::class.java,"yemek1.sqlite").
        createFromAsset("yemek1.sqlite").build()
        return vt.getRoomDao()
    }

}