package com.task.postlisttask.di

import com.task.postlisttask.data.entity.PostEntity
import com.task.postlisttask.data.local.AppDatabase
import com.task.postlisttask.data.local.Database
import com.task.postlisttask.data.local.PostDao
import com.task.postlisttask.data.mapper.Mapper
import com.task.postlisttask.data.mapper.PostMapper
import com.task.postlisttask.data.remute.Api
import com.task.postlisttask.data.repository.Repository
import com.task.postlisttask.domain.DataUseCase
import com.task.postlisttask.domain.NetworkConnectionManager
import com.task.postlisttask.view.models.Post
import io.ktor.client.HttpClient
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val factoryModule = module {
    single { Repository(get(), get(), get()) }
    single { get<AppDatabase>().postDao() }
    single { Database().getAppDatabase(androidApplication()) }
    single { NetworkConnectionManager(androidApplication()) }
    single { Api(get()) }

    factory {
        HttpClient {
            install(JsonFeature) {
                serializer = GsonSerializer()
            }
        }
    }

    factory { DataUseCase(get(), get()) }
    factory<Mapper<Post, PostEntity>> { PostMapper() }


}