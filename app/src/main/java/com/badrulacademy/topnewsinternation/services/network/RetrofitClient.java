package com.badrulacademy.topnewsinternation.services.network;

import com.badrulacademy.topnewsinternation.services.common.MyApp;
import com.chuckerteam.chucker.api.ChuckerInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient retrofitClient;
    private static Retrofit retrofit = null;
    private static String BASE_URL = "https://newsapi.org/";

    //for debugging purpose
    public OkHttpClient.Builder builder = new OkHttpClient.Builder();
    public HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

    public RetrofitClient(){
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(httpLoggingInterceptor);
        builder.addInterceptor(new ChuckerInterceptor(MyApp.context));


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(builder.build())//for Chucker
                .build();
    }
    public static synchronized RetrofitClient getInstance(){
        if(retrofitClient == null){
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }

    public ApiService getApi(){
        return retrofit.create(ApiService.class);
    }
}
