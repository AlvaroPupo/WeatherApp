package com.example.juanalvaropupo.weatherapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juanalvaropupo.weatherapp.api_calls.dark_sky.Weather;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.juanalvaropupo.weatherapp.MainActivity.PLACE;
import static com.example.juanalvaropupo.weatherapp.MainActivity.WEATHER;

public class WeatherFragment extends Fragment{

    private Weather weather;
    private String place;

    @BindView(R.id.layout_background)
    protected ConstraintLayout layout;
    @BindView(R.id.location_textview)
    protected TextView location;
    @BindView(R.id.weather_icon)
    protected ImageView weatherIcon;
    @BindView(R.id.summary_textview)
    protected TextView summary;
    @BindView(R.id.temp_high_textview)
    protected TextView tempHi;
    @BindView(R.id.temperature_low_textview)
    protected  TextView tempLow;
    @BindView(R.id.percent_precip_textview)
    protected  TextView precipChance;
    @BindView(R.id.temperature_textview)
    protected TextView currentTemp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        ButterKnife.bind(this, view);

        weather = getArguments().getParcelable(WEATHER);
        place = getArguments().getString(PLACE);

        return view;
    }

    public static WeatherFragment newInstance() {

        Bundle args = new Bundle();

        WeatherFragment fragment = new WeatherFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        location.setText(place);
        currentTemp.setText(getString(R.string.temperature, (int)Math.ceil(weather.getCurrentProperties().getTemperature())));

        summary.setText(weather.getCurrentProperties().getSummary());

        tempHi.setText(getString(R.string.temperature, (int)Math.ceil(weather.getDailyProperties().getDailyDataList().get(0)        .getTemperatureHigh())));

        tempLow.setText(getString(R.string.low_temp_format, (int)Math.ceil(weather.getDailyProperties().getDailyDataList().get(0).getTemperatureLow())));

        precipChance.setText(getString(R.string.precip_chance_format, 100 * (int)Math.ceil(weather.getDailyProperties().getDailyDataList().get(0).getPrecipProbability())));

        setWeatherIcon();
    }

    private void setWeatherIcon() {

        switch (weather.getCurrentProperties().getIcon()){
            case "clear-day":
                weatherIcon.setImageResource(R.drawable.clear_day);
                layout.setBackgroundResource(R.color.sunColor);
                break;
            case "clear-night":
                weatherIcon.setImageResource(R.drawable.clear_night);
                layout.setBackgroundResource(R.color.nightColor);
                break;
            case "rain":
                weatherIcon.setImageResource(R.drawable.rain);
                layout.setBackgroundResource(R.color.rainColor);
                break;
            case "snow":
                weatherIcon.setImageResource(R.drawable.snow);
                layout.setBackgroundResource(R.color.snowColor);
                break;
            case "sleet":
                weatherIcon.setImageResource(R.drawable.sleet);
                layout.setBackgroundResource(R.color.sleetColor);
                break;
            case "wind":
                weatherIcon.setImageResource(R.drawable.wind);
                layout.setBackgroundResource(R.color.sleetColor);
                break;
            case "fog":
                weatherIcon.setImageResource(R.drawable.fog);
                layout.setBackgroundResource(R.color.cloudyColor);
                break;
            case "cloudy":
                weatherIcon.setImageResource(R.drawable.cloudy);
                layout.setBackgroundResource(R.color.cloudyColor);
                break;
            case "partly-cloudy-day":
                weatherIcon.setImageResource(R.drawable.partly_cloudy_day);
                layout.setBackgroundResource(R.color.defaultColor);
                break;
            case "partly-cloudy-night":
                weatherIcon.setImageResource(R.drawable.partly_cloudy_night);
                layout.setBackgroundResource(R.color.stormColor);
                break;
        }
    }
}
