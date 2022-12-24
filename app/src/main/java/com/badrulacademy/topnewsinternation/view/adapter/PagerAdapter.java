package com.badrulacademy.topnewsinternation.view.adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.badrulacademy.topnewsinternation.view.ui.BusinessFragment;
import com.badrulacademy.topnewsinternation.view.ui.EntertainmentFragment;
import com.badrulacademy.topnewsinternation.view.ui.HealthFragment;
import com.badrulacademy.topnewsinternation.view.ui.HomeFragment;
import com.badrulacademy.topnewsinternation.view.ui.ScienceFragment;
import com.badrulacademy.topnewsinternation.view.ui.SportsFragment;
import com.badrulacademy.topnewsinternation.view.ui.TechnologyFragment;

public class PagerAdapter extends FragmentStateAdapter {
    public PagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Log.e("FRAGMENTPOSITION", "createFragment: POSITION="+position);
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new SportsFragment();
            case 2:
                return new HealthFragment();
            case 3:
                return new ScienceFragment();
            case 4:
                return new EntertainmentFragment();
            case 5:
                return new TechnologyFragment();
            case 6:
                return new BusinessFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 7;
    }
}
