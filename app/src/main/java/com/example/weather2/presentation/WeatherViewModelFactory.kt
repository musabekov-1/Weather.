package com.example.weather2.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weather2.domain.GetWeatherUseCase

class WeatherViewModelFactory(private val getWeatherUseCase: GetWeatherUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WeatherViewModel(getWeatherUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
