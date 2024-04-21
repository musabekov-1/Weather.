package com.example.weather2.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather2.domain.GetWeatherUseCase
import com.example.weather2.response.WeatherResponse
import kotlinx.coroutines.launch

class WeatherViewModel(private val getWeatherUseCase: GetWeatherUseCase) : ViewModel() {

    val weatherResponse: MutableLiveData<WeatherResponse> = MutableLiveData()

    fun getWeather(location: String, days: Int, aqi: String, alerts: String) {
        viewModelScope.launch {
            val response = getWeatherUseCase.execute(location, days, aqi, alerts)
            weatherResponse.postValue(response)
        }
    }
}