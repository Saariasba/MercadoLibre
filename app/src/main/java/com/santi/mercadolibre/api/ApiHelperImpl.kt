package com.santi.mercadolibre.api

import com.santi.mercadolibre.models.SearchResponse
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
) : ApiHelper {
    override suspend fun getSearch(keyword: String): Response<SearchResponse> =
        apiService.getSearch(keyword)
}