package com.santi.mercadolibre.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santi.mercadolibre.models.SearchResponse
import com.santi.mercadolibre.repository.MainRepository
import com.santi.mercadolibre.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _keyword = MutableLiveData<String>()
    val keyword: LiveData<String> = _keyword

    private val _res = MutableLiveData<Resource<SearchResponse>>()
    val res: LiveData<Resource<SearchResponse>>
        get() = _res

    fun getSearch(keyword: String) = viewModelScope.launch {
        _keyword.value = keyword
        _res.postValue(Resource.loading(null))
        repository.getSearch(_keyword.value.toString()).let {
            if (it.isSuccessful) {
                _res.postValue(Resource.success(it.body()))
            } else {
                _res.postValue(Resource.error(it.errorBody().toString(), null))
            }
        }
    }
}