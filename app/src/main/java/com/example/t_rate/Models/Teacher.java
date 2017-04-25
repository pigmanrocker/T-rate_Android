package com.example.t_rate.Models;

/**
 * Created by pigmanrocker on 25-4-17.
 */

public class Teacher {

    private int id;
    private String name;
    private float totalRating;

    public Teacher(int id, String name, float totalRating){
        this.id = id;
        this.name = name;
        this.totalRating = totalRating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(float totalRating) {
        this.totalRating = totalRating;
    }
}
