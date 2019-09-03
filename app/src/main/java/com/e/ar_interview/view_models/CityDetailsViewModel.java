package com.e.ar_interview.view_models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.e.ar_interview.model.CityData;
import com.e.ar_interview.remote.ApiCall;
import com.e.ar_interview.remote.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shalvi on 9/2/2019.
 */

public class CityDetailsViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously
    private MutableLiveData<CityData> cityList;

    private ApiCall apiCall;


    //we will call this method to get the data
    public LiveData<CityData> getCityDetails() {

        //if the list is null
        if (cityList == null) {
            cityList = new MutableLiveData<CityData>();
            loadCityDetails();        //we will load it asynchronously from server in this method
        }
        return cityList;  //finally we will return the list
    }

    //This method is using Retrofit to get the JSON data from URL
    private void loadCityDetails() {

        apiCall = ApiUtils.getCityDetails();

        Call<CityData> call = apiCall.getCityDetails();

        call.enqueue(new Callback<CityData>() {
            @Override
            public void onResponse(Call<CityData> call, Response<CityData> response) {

                //finally we are setting the list to our MutableLiveData
                cityList.setValue(response.body());

            }

            @Override
            public void onFailure(Call<CityData> call, Throwable t) {
                System.out.println("is failed");
            }
        });
    }

}
