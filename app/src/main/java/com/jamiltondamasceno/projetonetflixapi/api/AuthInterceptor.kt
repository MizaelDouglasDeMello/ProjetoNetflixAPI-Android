package com.jamiltondamasceno.projetonetflixapi.api

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val construcaoRequisicao = chain.request().newBuilder()

        val urlAtual = chain.request().url()
        val novaUrl = urlAtual.newBuilder()
            .addQueryParameter("api_key", RetrofitService.API_KEY)
            .addQueryParameter("language", "pt-BR")

        construcaoRequisicao.url(novaUrl.build())

        return chain.proceed(construcaoRequisicao.build())
    }
}

//&api_key=${RetrofitService.API_KEY}