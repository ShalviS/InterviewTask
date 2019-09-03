package com.e.ar_interview.remote;

import com.e.ar_interview.model.CityData;

import retrofit2.Call;
import retrofit2.http.GET;
/**
 * Created by shalvi on 9/2/2019.
 */
public interface ApiCall {

 //Api for getting city details
    @GET("facts.json")
    Call<CityData> getCityDetails();

}
