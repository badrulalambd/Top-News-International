package com.badrulacademy.topnewsinternation.services.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.badrulacademy.topnewsinternation.services.model.ModelClass;
import com.badrulacademy.topnewsinternation.services.model.ModelDataClass;
import com.badrulacademy.topnewsinternation.services.network.RetrofitClient;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {

    private static NewsRepository mInstance;
    private ModelClass newsModel;
    private List<ModelDataClass> mResult;
    private MutableLiveData<List<ModelDataClass>> mLiveData;

    private String apiKey = "c05c2348b2ba41b4ad9eb579edd9d029";
    private String country= "us";
    private int pageSize = 20;

    public static NewsRepository getInstance(){
        if(mInstance == null){
            mInstance = new NewsRepository();
        }
        return mInstance;
    }

    public MutableLiveData<List<ModelDataClass>> getNewsList(String category){
        if(mLiveData == null){
            mLiveData = new MutableLiveData<>();
        }

        RetrofitClient.getInstance()
                .getApi()
                .getNews(country,category,apiKey,pageSize)
                .enqueue(new Callback<ModelClass>() {
            @Override
            public void onResponse(Call<ModelClass> call, Response<ModelClass> response) {
                Log.d("RESPONSES", "onResponse: RESPONSE="+ new Gson().toJson(response.body()));
                newsModel = response.body();
                mResult = newsModel.getArticles();
                mLiveData.postValue(mResult);
            }

            @Override
            public void onFailure(Call<ModelClass> call, Throwable t) {

            }
        });

        return mLiveData;
    }
}
