package com.example.t_rate.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.t_rate.Models.Teacher;
import com.example.t_rate.databinding.LayoutTeacherCardSmallBinding;

import java.util.ArrayList;

/**
 * Created by pigmanrocker on 25-4-17.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.VH_teacher_card_small>{

    private ArrayList<Teacher> teachers = new ArrayList<>();

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    @Override
    public int getItemCount() {
        return teachers.size();
    }

    @Override
    public void onBindViewHolder(VH_teacher_card_small holder, int position) {
        Teacher teacher = teachers.get(position);
        holder.bind(teacher);
    }

    @Override
    public VH_teacher_card_small onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        LayoutTeacherCardSmallBinding teacherBinding = LayoutTeacherCardSmallBinding.inflate(layoutInflater, parent, false);
        return new VH_teacher_card_small(teacherBinding);
    }

    public class VH_teacher_card_small extends RecyclerView.ViewHolder{

        private final LayoutTeacherCardSmallBinding binding;

        public VH_teacher_card_small(LayoutTeacherCardSmallBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Teacher teacher) {
            binding.setTeacher(teacher);
            binding.executePendingBindings();
        }
    }
}
