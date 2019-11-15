package com.daniel.android.relifemanager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Routine {

    private UUID mUUID;

    private String mName;
    private List<Habit> mHabitList;

    public Routine() {
        mName = "Routine";
        mHabitList = new ArrayList<>();
        mUUID = UUID.randomUUID();
    }

    public Routine(String name) {
        this();
        mName = name;
    }
    public Routine(List<Habit> habitList) {
        this();
        mHabitList = habitList;
    }

    public Routine(String name, List<Habit> habitList) {
        this();
        mName = name;
        mHabitList = habitList;
    }

    public Habit getHabitAt(int index) {
        if (index < mHabitList.size()) {
            return mHabitList.get(index);
        } else {
            return null;
        }
    }

    public List<Habit> getHabitList() {
        return mHabitList;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public UUID getUUID() {
        return mUUID;
    }
}
