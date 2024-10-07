package com.jamiltondamasceno.projetonetflixapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    companion object {

        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val BASE_URL_IMAGEM = "https://image.tmdb.org/t/p/"
        const val API_KEY = "2fa69fb1ffab6d49dddd71e9be7f9651"

        val retrofit = Retrofit.Builder()
            .baseUrl( BASE_URL )
            .addConverterFactory( GsonConverterFactory.create() )
            .build()

        val filmeAPI = retrofit.create( FilmeAPI::class.java )
    }
}