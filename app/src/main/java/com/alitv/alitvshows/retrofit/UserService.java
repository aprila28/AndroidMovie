package com.alitv.alitvshows.retrofit;


import com.alitv.alitvshows.model.RegisterResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserService {
    @FormUrlEncoded
    @POST("api/user")
    Call<RegisterResponseModel> register(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("address") String address
    );
}
