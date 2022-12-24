package com.badrulacademy.topnewsinternation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.badrulacademy.topnewsinternation.services.model.ModelDataClass;
import com.badrulacademy.topnewsinternation.services.repository.NewsRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private NewsRepository mRepo;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mRepo = NewsRepository.getInstance();
    }

    public MutableLiveData<List<ModelDataClass>> getNewsList(String category){
        return mRepo.getNewsList(category);
    }

}
