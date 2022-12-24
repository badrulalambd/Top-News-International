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

public class ScienceFragment extends Fragment {

    private RecyclerView recyclerViewOfScience;
    private NewsAdapter adapter;
    private String category = "science";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_science, container, false);

        recyclerViewOfScience = view.findViewById(R.id.recyclerView_science_id);
        recyclerViewOfScience.setHasFixedSize(true);
        recyclerViewOfScience.setLayoutManager(new LinearLayoutManager(getContext()));

        MainViewModel model = new ViewModelProvider(this).get(MainViewModel.class);
        model.getNewsList(category).observe(getViewLifecycleOwner(), new Observer<List<ModelDataClass>>() {
            @Override
            public void onChanged(List<ModelDataClass> result) {
                adapter = new NewsAdapter(getContext(), result);
                recyclerViewOfScience.setAdapter(adapter);

            }
        });

        return view;
    }
}