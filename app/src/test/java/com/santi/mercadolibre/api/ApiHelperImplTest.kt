package com.santi.mercadolibre.api

import com.santi.mercadolibre.models.CategoriesResponse
import com.santi.mercadolibre.models.ProductResponse
import com.santi.mercadolibre.models.SearchResponse
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.given
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class ApiHelperImplTest {

    @Mock
    private lateinit var apiService: ApiService

    private lateinit var apiHelperImpl: ApiHelperImpl

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        init()
    }

    private fun init() {
        apiHelperImpl = ApiHelperImpl(
            apiService
        )
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getSearch() = runTest {
        val response = SearchResponse()
        given(apiService.getSearch("keyword")).willReturn(Response.success(response))
        val data = apiHelperImpl.getSearch("keyword")
        assertEquals(response, data.body())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getProduct() = runTest {
        val response = ProductResponse()
        given(apiService.getProduct("id")).willReturn(Response.success(response))
        val data = apiHelperImpl.getProduct("id")
        assertEquals(response, data.body())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getCategories() = runTest {
        val response = CategoriesResponse()
        given(apiService.getCategories()).willReturn(Response.success(listOf(response)))
        val data = apiHelperImpl.getCategories()
        assertEquals(response, data.body())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getCategory() = runTest {
        val response = SearchResponse()
        given(apiService.getCategory("category")).willReturn(Response.success(response))
        val data = apiHelperImpl.getCategory("category")
        assertEquals(response, data.body())
    }
}