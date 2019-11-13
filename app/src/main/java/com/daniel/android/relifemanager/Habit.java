package com.daniel.android.relifemanager;

public class Habit {

    private String mName;

    public Habit() {
        mName = "Habit";
    }

    public Habit(String name) {
        this();
        mName = name;
    }

    public String getName() {
        return mName;
    }
}
