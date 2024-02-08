package com.example.weatherapp.data.datasource.di

import com.example.weatherapp.BuildConfig
import com.example.weatherapp.data.datasource.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideApiService(
        retrofit: Retrofit
    ) : ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        client: OkHttpClient
    ) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideOkhttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        var okhttpBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original  = chain.request()
                val request = original.newBuilder()
                    .method(original.method, original.body)
                    .build()
                chain.proceed(request)
            }
            .addInterceptor { chain ->
                val url = chain.request()
                    .url
                    .newBuilder()
                    .addQueryParameter("apiKey", BuildConfig.API_KEY)
                    .build()
                val request = chain.request().newBuilder().url(url).build()
                chain.proceed(request)
            }

        if (BuildConfig.DEBUG){
            okhttpBuilder = okhttpBuilder.addInterceptor(loggingInterceptor)
        }
        return okhttpBuilder.build()
    }
}
