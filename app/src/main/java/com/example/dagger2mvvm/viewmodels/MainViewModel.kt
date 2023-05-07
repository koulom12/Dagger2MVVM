package com.example.dagger2mvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dagger2mvvm.models.Product
import com.example.dagger2mvvm.repository.ProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(val repository: ProductRepository) : ViewModel() {

    private val _productsList : MutableLiveData<ArrayList<Product>> = MutableLiveData()
    val productsList : LiveData<ArrayList<Product>> = _productsList

    init {
        viewModelScope.launch {
            _productsList.postValue(repository.getProducts())
        }
    }

}