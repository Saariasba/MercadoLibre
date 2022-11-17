package com.santi.mercadolibre.api

import com.santi.mercadolibre.models.ProductResponse
import com.santi.mercadolibre.models.SearchResponse
import retrofit2.Response
import javax.inject.Inject

//Implementación de ApiHelper
class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
) : ApiHelper {
    override suspend fun getSearch(keyword: String): Response<SearchResponse> =
        apiService.getSearch(keyword)

    override suspend fun getProduct(id: String): Response<ProductResponse> =
        apiService.getProduct(id)

}