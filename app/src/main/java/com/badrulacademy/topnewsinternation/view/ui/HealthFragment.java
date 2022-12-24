package com.badrulacademy.topnewsinternation.view.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.badrulacademy.topnewsinternation.R;
import com.badrulacademy.topnewsinternation.services.model.ModelDataClass;
import com.badrulacademy.topnewsinternation.view.adapter.NewsAdapter;
import com.badrulacademy.topnewsinternation.viewmodel.MainViewModel;

import java.util.List;

public class HealthFragment extends Fragment {

    private RecyclerView recyclerViewOfHealth;
    private NewsAdapter adapter;
    private String category = "health";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_health, container, false);

        recyclerViewOfHealth = view.findViewById(R.id.recyclerView_health_id);
        recyclerViewOfHealth.setHasFixedSize(true);
        recyclerViewOfHealth.setLayoutManager(new LinearLayoutManager(getContext()));

        MainViewModel model = new ViewModelProvider(this).get(MainViewModel.class);
        model.getNewsList(category).observe(getViewLifecycleOwner(), new Observer<List<ModelDataClass>>() {
            @Override
            public void onChanged(List<ModelDataClass> result) {
                adapter = new NewsAdapter(getContext(), result);
                recyclerViewOfHealth.setAdapter(adapter);

            }
        });

        return view;
    }
}