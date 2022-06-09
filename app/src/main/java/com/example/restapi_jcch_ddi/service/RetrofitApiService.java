package com.example.restapi_jcch_ddi.service;

import com.example.restapi_jcch_ddi.entity.Message;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitApiService {

    @GET("posts/{id}")
    Call<Message> getMessageId(@Path("id") int id);
}
