package com.e.ar_interview.remote;
/**
 * Created by shalvi on 9/2/2019.
 */
public class ApiUtils {

    public static final String BASE_URL ="https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/";

    public static ApiCall getCityDetails(){
        return RetrofitClient.getClient(BASE_URL).create(ApiCall.class);
    }

}
