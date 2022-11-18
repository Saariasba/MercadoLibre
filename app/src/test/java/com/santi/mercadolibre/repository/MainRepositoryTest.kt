package com.santi.mercadolibre.repository

import com.santi.mercadolibre.api.ApiHelper
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
class MainViewModelTest {

    @Mock
    private lateinit var apiHelper: ApiHelper

    private lateinit var mainRepository: MainRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        init()
    }

    private fun init() {
        mainRepository = MainRepository(
            apiHelper
        )
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getSearch() = runTest {
        val response = SearchResponse()
        given(apiHelper.getSearch("keyword")).willReturn(Response.success(response))
        val data = mainRepository.getSearch("keyword")
        assertEquals(response, data.body())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getProduct() = runTest {
        val response = ProductResponse()
        given(apiHelper.getProduct("id")).willReturn(Response.success(response))
        val data = mainRepository.getProduct("id")
        assertEquals(response, data.body())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getCategories() = runTest {
        val response = CategoriesResponse()
        given(apiHelper.getCategories()).willReturn(Response.success(listOf(response)))
        val data = mainRepository.getCategories()
        assertEquals(response, data.body())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getCategory() = runTest {
        val response = SearchResponse()
        given(apiHelper.getCategory("category")).willReturn(Response.success(response))
        val data = mainRepository.getCategory("category")
        assertEquals(response, data.body())
    }
}