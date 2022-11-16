package com.santi.mercadolibre.api

import com.santi.mercadolibre.models.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/products/search?status=active&site_id=MLA")
    suspend fun getSearch(@Query("q") keyword: String): Response<SearchResponse>
}