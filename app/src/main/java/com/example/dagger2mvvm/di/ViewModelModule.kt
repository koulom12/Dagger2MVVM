package com.example.dagger2mvvm.di

import androidx.lifecycle.ViewModel
import com.example.dagger2mvvm.viewmodels.MainViewModel
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @ClassKey(MainViewModel::class)
    @IntoMap
    abstract fun provideViewModel(@BindsInstance mainViewModel: MainViewModel): ViewModel
}