package com.example.t_rate.Presenters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.t_rate.Activities.HomeActivity;
import com.example.t_rate.Adapters.HomeAdapter;
import com.example.t_rate.Models.HomeModel;
import com.example.t_rate.Models.Teacher;
import com.example.t_rate.R;
import com.example.t_rate.databinding.ActivityHomeBinding;

import java.util.ArrayList;

/**
 * Created by pigmanrocker on 24-4-17.
 */

public class HomePresenter {

    private ActivityHomeBinding binding;
    private HomeActivity homeActivity;
    private RecyclerView recyclerView;
    private HomeAdapter adapter;
    private HomeModel model;

    public HomePresenter(HomeActivity homeActivity){
        this.homeActivity = homeActivity;
        adapter = new HomeAdapter();
        binding = DataBindingUtil.setContentView(homeActivity, R.layout.activity_home);
        binding.setPresenter(this);
        binding.setModel(model);
        recyclerView = binding.homeRecycler;
        recyclerView.setLayoutManager(new LinearLayoutManager(homeActivity.getBaseContext()));
        recyclerView.setAdapter(adapter);

        testRecyclerView();
    }

    public void testRecyclerView(){
        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher(1, "Raymond Blankestijn", (float) 4.4));
        teachers.add(new Teacher(1, "Winnie van Schild", (float) 3.4));
        teachers.add(new Teacher(1, "Jochen den Ouden", (float) 2.0));
        teachers.add(new Teacher(1, "Niels Doorn", (float) 4.6));
        teachers.add(new Teacher(1, "Rob Smit", (float) 3.6));
        teachers.add(new Teacher(1, "Jakob Loer", (float) 4.7));
        teachers.add(new Teacher(1, "Rina Drijfholt", (float) 4.2));
        teachers.add(new Teacher(1, "Rene van Bolhuis", (float) 1.3));
        teachers.add(new Teacher(1, "Rene Laan", (float) 2.7));
        teachers.add(new Teacher(1, "Johan ten Brink", (float) 4.2));
        teachers.add(new Teacher(1, "Henk Bakker", (float) 5.0));

        adapter.setTeachers(teachers);
        adapter.notifyDataSetChanged();
    }
}
