package com.example.stockwatch.di

import com.example.stockwatch.core.DefaultDispatcherProvider
import com.example.stockwatch.core.DispatcherProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CoreModule {
    @Binds
    abstract fun dispatchers(impl: DefaultDispatcherProvider): DispatcherProvider
}