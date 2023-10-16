package com.example.composetest.di

import android.content.Context
import com.example.composetest.models.FirstGame
import com.example.composetest.models.SecondGame
import com.example.composetest.models.ThirdGame
import com.example.composetest.repositories.FirstRepository
import com.example.composetest.repositories.MainRepository
import com.example.composetest.repositories.SecondRepository
import com.example.composetest.repositories.ThirdRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides fun provideFirstRepo(@ApplicationContext context: Context):MainRepository<FirstGame>{
        return FirstRepository(context)
    }

    @Provides
    fun provideSecondRepo(@ApplicationContext context: Context):MainRepository<SecondGame>{
        return SecondRepository(context)
    }

    @Provides
    fun provideThirdRepo(@ApplicationContext context:Context):MainRepository<ThirdGame>{
        return ThirdRepository(context)
    }

}