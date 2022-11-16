package com.santi.mercadolibre.api

import com.santi.mercadolibre.models.SearchResponse
import retrofit2.Response

interface ApiHelper {
    suspend fun getSearch(keyword: String): Response<SearchResponse>
}