package com.jamiltondamasceno.projetonetflixapi.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitService {
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val BASE_URL_IMAGEM = "https://image.tmdb.org/t/p/"
    const val API_KEY = "2fa69fb1ffab6d49dddd71e9be7f9651"

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .writeTimeout(10,TimeUnit.SECONDS) // ESCRITA(SALVANDO)
        .readTimeout(20,TimeUnit.SECONDS) // LEITURA (RECUPERANDO)
        .connectTimeout(20,TimeUnit.SECONDS) // CONEXÃO (ESTABELECIMENTO DA CONEXÃO)
        .addInterceptor(AuthInterceptor())
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl( BASE_URL )
        .addConverterFactory( GsonConverterFactory.create() )
        .client( okHttpClient )
        .build()

    val filmeAPI = retrofit.create( FilmeAPI::class.java )
}