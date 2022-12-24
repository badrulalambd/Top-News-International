package com.badrulacademy.topnewsinternation.services.network;

import com.badrulacademy.topnewsinternation.services.model.ModelClass;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("v2/top-headlines")
    Call<ModelClass> getNews(
            @Query("country") String country,
            @Query("apiKey") String apiKey,
            @Query("pageSize") int pageSize
    );

    @GET("v2/top-headlines")
    Call<ModelClass> getNews(
            @Query("country") String country,
            @Query("category") String category,
            @Query("apiKey") String apiKey,
            @Query("pageSize") int pageSize
    );

}
