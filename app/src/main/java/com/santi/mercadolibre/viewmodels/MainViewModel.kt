package com.santi.mercadolibre.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santi.mercadolibre.models.ResponseResult
import com.santi.mercadolibre.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _keyword = MutableLiveData<String>()
    val keyword: LiveData<String> = _keyword

    private val _products = MutableLiveData<List<ResponseResult>>()
    val products: LiveData<List<ResponseResult>> = _products

    fun getSearch(keyword: String) = viewModelScope.launch {
        _keyword.value = keyword
        repository.getSearch(_keyword.value.toString()).let {
            if (it.isSuccessful) {
                _products.postValue(it.body()?.results)
            }
        }
    }
}