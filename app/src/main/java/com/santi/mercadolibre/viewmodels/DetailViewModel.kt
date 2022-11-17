package com.santi.mercadolibre.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santi.mercadolibre.models.ProductResponse
import com.santi.mercadolibre.models.ResponseResult
import com.santi.mercadolibre.repository.MainRepository
import com.santi.mercadolibre.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _product = MutableStateFlow<Resource<ProductResponse>>(Resource.loading())
    val product: StateFlow<Resource<ProductResponse>> get() = _product

    fun getProduct(id: String) = viewModelScope.launch {
        repository.getProduct(id).let {
            if (it.isSuccessful) {
                _product.value = Resource.success(it.body())
                Log.d("Prueba", "vamos: ${it.body()}")
            }
        }
    }
}