package com.example.juanalvaropupo.weatherapp.api_calls.dark_sky;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Weather implements Parcelable{

    @SerializedName("latitude")
    private double latitude;

    @SerializedName("longitude")
    private double longitude;

    @SerializedName("currently")
    private CurrentProperties currentProperties;

    @SerializedName("daily")
    private DailyProperties dailyProperties;

    protected Weather(Parcel in) {
        latitude = in.readDouble();
        longitude = in.readDouble();
    }

    public static final Creator<Weather> CREATOR = new Creator<Weather>() {
        @Override
        public Weather createFromParcel(Parcel in) {
            return new Weather(in);
        }

        @Override
        public Weather[] newArray(int size) {
            return new Weather[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public CurrentProperties getCurrentProperties() {
        return currentProperties;
    }

    public DailyProperties getDailyProperties() {
        return dailyProperties;
    }
    public class CurrentProperties{

        @SerializedName("summary")
        private String summary;

        @SerializedName("icon")
        private String icon;

        @SerializedName("temperature")
        private double temperature;

        public String getSummary() {
            return summary;
        }

        public String getIcon() {
            return icon;
        }

        public double getTemperature() {
            return temperature;
        }
    }
    public class DailyProperties{

        @SerializedName("data")
        private List<DailyData> dailyDataList;

        public List<DailyData> getDailyDataList() {
            return dailyDataList;
        }
        public class DailyData{

            @SerializedName("precipProbability")
            private double precipProbability;

            @SerializedName("temperatureHigh")
            private double temperatureHigh;

            @SerializedName("temperatureLow")
            private double temperatureLow;

            public double getPrecipProbability() {
                return precipProbability;
            }

            public double getTemperatureHigh() {
                return temperatureHigh;
            }

            public double getTemperatureLow() {
                return temperatureLow;
            }
        }
    }
}

