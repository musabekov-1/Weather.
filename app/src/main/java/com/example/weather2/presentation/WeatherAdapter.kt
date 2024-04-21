package com.example.weather2.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weather2.databinding.ItemWeatherBinding
import com.example.weather2.response.Hour
import com.example.weather2.response.ForecastDay
import java.text.SimpleDateFormat
import java.util.*

class WeatherAdapter : ListAdapter<Pair<Hour, ForecastDay>, WeatherAdapter.WeatherViewHolder>(
    DiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val binding = ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem.first, currentItem.second)
    }

    inner class WeatherViewHolder(private val binding: ItemWeatherBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(hour: Hour, forecastDay: ForecastDay) {
            binding.apply {
                if (hour.time.endsWith("00:00")) {
                    tvDay.text = getDayOfWeek(forecastDay.date)
                } else {
                    tvDay.text = ""
                }
                tvTime.text = getTime(hour.time)
                tvGradusRv.text = "${hour.temp_c}C"
                tvWeatherRv.text = hour.condition.text
            }
        }

        private fun getDayOfWeek(date: String): String {
            val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val date = format.parse(date)
            val formatDayOfWeek = SimpleDateFormat("EEEE", Locale.getDefault())
            return formatDayOfWeek.format(date)
        }

        private fun getTime(time: String): String {
            val format = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
            val date = format.parse(time)
            val formatTime = SimpleDateFormat("HH:mm", Locale.getDefault())
            return formatTime.format(date)
        }
    }


    class DiffCallback : DiffUtil.ItemCallback<Pair<Hour, ForecastDay>>() {
        override fun areItemsTheSame(oldItem: Pair<Hour, ForecastDay>, newItem: Pair<Hour, ForecastDay>) =
            oldItem.first.time_epoch == newItem.first.time_epoch

        override fun areContentsTheSame(oldItem: Pair<Hour, ForecastDay>, newItem: Pair<Hour, ForecastDay>) =
            oldItem == newItem
    }
}
