package com.e.ar_interview.remote;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shalvi on 9/2/2019.
 */
public class RetrofitClient {

    // create a retrofit client for connect a server
    private static Retrofit retrofit = null;

    public static Retrofit getClient(String url) {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}