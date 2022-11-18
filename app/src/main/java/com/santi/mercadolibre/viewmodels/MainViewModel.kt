package com.santi.mercadolibre.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santi.mercadolibre.models.CategoriesResponse
import com.santi.mercadolibre.models.SearchResponse
import com.santi.mercadolibre.repository.MainRepository
import com.santi.mercadolibre.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//ViewModel de la vista principal o home
@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _keyword = MutableLiveData<String>()
    val keyword: LiveData<String> = _keyword

    private val _products = MutableStateFlow(Resource.success(SearchResponse()))
    val products: StateFlow<Resource<SearchResponse>> get() = _products

    private val _categories = MutableStateFlow(Resource.success(listOf(CategoriesResponse())))
    val categories: StateFlow<Resource<List<CategoriesResponse>>> get() = _categories

    init {
        getCategories()
    }

    fun setKeyword(keyword: String) {
        _keyword.value = keyword
    }

    //Llamado de servicio por Coroutine para obtener productos
    fun getSearch(keyword: String) = viewModelScope.launch {
        _keyword.value = keyword
        _products.value = Resource.loading()
        repository.getSearch(_keyword.value.toString()).let {
            if (it.isSuccessful) {
                _products.value = Resource.success(it.body())
            } else {
                _products.value = Resource.error(it.message(), it.body())
            }
        }
    }

    fun getCategories() = viewModelScope.launch {
        _categories.value = Resource.loading()
        repository.getCategories().let {
            if (it.isSuccessful) {
                _categories.value = Resource.success(it.body())
            } else {
                _categories.value = Resource.error(it.message(), it.body())
            }
        }
    }

    fun getCategory(id: String) = viewModelScope.launch {
        _products.value = Resource.loading()
        repository.getCategory(id).let {
            if (it.isSuccessful) {
                _products.value = Resource.success(it.body())
            } else {
                _products.value = Resource.error(it.message(), it.body())
            }
        }
    }
}