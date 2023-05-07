package com.example.dagger2mvvm

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dagger2mvvm.databinding.ActivityMainBinding
import com.example.dagger2mvvm.di.AppComponent
import com.example.dagger2mvvm.di.DaggerAppComponent
import com.example.dagger2mvvm.viewmodels.MainViewModel
import com.example.dagger2mvvm.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject lateinit var mainViewModelFactory : MainViewModelFactory
    lateinit var mainViewModel: MainViewModel

    @Inject lateinit var appComponent: AppComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appComponent = (application as FakerApplication).appComponent
        appComponent.inject(this)

        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)


        mainViewModel.productsList.observe(this, Observer {
            binding.tvText.text = it.joinToString { it.title }
        })


    }
}