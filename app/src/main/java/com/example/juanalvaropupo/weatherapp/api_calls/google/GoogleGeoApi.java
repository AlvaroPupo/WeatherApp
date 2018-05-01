package com.example.juanalvaropupo.weatherapp.api_calls.google;

import android.provider.CallLog;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoogleGeoApi {

    @GET("json")
    Call<GoogleAddress> getAdress(@Query("address")String address, @Query("api_key") String apikey);

}
