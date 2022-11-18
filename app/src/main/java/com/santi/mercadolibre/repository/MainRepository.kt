package com.santi.mercadolibre.repository

import com.santi.mercadolibre.api.ApiHelper
import javax.inject.Inject

//Repository que gestiona el llamado a ApiHelper
class MainRepository @Inject constructor(
    private val apiHelper: ApiHelper
) {
    suspend fun getSearch(keyword: String) = apiHelper.getSearch(keyword)

    suspend fun getProduct(id: String) = apiHelper.getProduct(id)

    suspend fun getCategories() = apiHelper.getCategories()

    suspend fun getCategory(category: String) = apiHelper.getCategory(category)
}