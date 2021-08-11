package com.threeadvance.android.di

import com.google.gson.GsonBuilder
import com.threeadvance.android.data.remote.ResourceParser
import com.threeadvance.android.data.remote.SampleApi
import com.threeadvance.android.data.repository.CollectionRepository
import com.threeadvance.android.data.repository.CollectionRepositoryContract
import com.threeadvance.android.ui.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { GsonBuilder().create() }
    single { SampleApi(resourceParser = get()) }
    single { ResourceParser.getInstance(androidApplication()) }

    single<CollectionRepositoryContract> { CollectionRepository(api = get()) } bind CollectionRepositoryContract::class

    viewModel { MainViewModel(collectionRepository = get()) }
}