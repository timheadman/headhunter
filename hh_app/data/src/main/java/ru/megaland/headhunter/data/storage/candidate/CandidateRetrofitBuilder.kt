package ru.megaland.headhunter.data.storage.candidate

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CandidateRetrofitBuilder {

    val apiService: CandidateStorageApi = getInstance().create(CandidateStorageApi::class.java)
    private const val baseUrl = "http://10.11.12.1:8080/"

    private fun provideOkhttp(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    private fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(provideOkhttp())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}