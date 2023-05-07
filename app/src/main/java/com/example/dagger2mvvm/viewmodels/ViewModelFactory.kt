package com.example.dagger2mvvm.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dagger2mvvm.repository.ProductRepository
import javax.inject.Inject

class ViewModelFactory @Inject constructor(val map: Map<Class<*>, @JvmSuppressWildcards ViewModel>) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return map[modelClass] as T
    }
}