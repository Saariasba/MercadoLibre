package com.santi.mercadolibre.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santi.mercadolibre.models.ProductResponse
import com.santi.mercadolibre.repository.MainRepository
import com.santi.mercadolibre.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//ViewModel de la vista de detalle
@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _product = MutableStateFlow<Resource<ProductResponse>>(Resource.loading())
    val product: StateFlow<Resource<ProductResponse>> get() = _product

    //Llamado de servicio por Coroutine
    fun getProduct(id: String) = viewModelScope.launch {
        repository.getProduct(id).let {
            if (it.isSuccessful) {
                _product.value = Resource.success(it.body())
            }
        }
    }
}