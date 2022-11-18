package com.santi.mercadolibre.viewmodels

import com.santi.mercadolibre.repository.MainRepository
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @Mock
    private lateinit var repository: MainRepository

    private lateinit var mainViewModel: MainViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        initViewModel()
    }

    private fun initViewModel() {
        mainViewModel = MainViewModel(
            repository
        )
    }
}