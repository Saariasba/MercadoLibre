package com.santi.mercadolibre.repository

import com.santi.mercadolibre.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiHelper: ApiHelper
) {
    suspend fun getSearch(keyword: String) = apiHelper.getSearch(keyword)

    suspend fun getProduct(id: String) = apiHelper.getProduct(id)
}