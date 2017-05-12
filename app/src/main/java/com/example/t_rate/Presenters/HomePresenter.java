package com.example.t_rate.Presenters;

import com.example.t_rate.Activities.HomeActivity;
import com.example.t_rate.Adapters.HomeAdapter;
import com.example.t_rate.Models.Teacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by pigmanrocker on 24-4-17.
 */

public class HomePresenter {

    private HomeActivity homeActivity;
    private HomeAdapter adapter;

    public HomePresenter(HomeActivity homeActivity){
        this.homeActivity = homeActivity;
        adapter = new HomeAdapter();
        homeActivity.setRecyclerAdapter(adapter);

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

        Collections.sort(teachers, new Comparator<Teacher>() {
            @Override
            public int compare(Teacher teacher1, Teacher teacher2) {
                if (teacher1.getTotalRating() < teacher2.getTotalRating()){
                    return 1;
                } else if (teacher1.getTotalRating() > teacher2.getTotalRating()){
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        adapter.setTeachers(teachers);
        adapter.notifyDataSetChanged();
    }
}
