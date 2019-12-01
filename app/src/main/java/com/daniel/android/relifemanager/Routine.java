package com.daniel.android.relifemanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Routine {

    private String mID;
    private String mName;
    private List<Habit> mHabitList;

    public Routine() {
        mName = "Routine";
        mHabitList = new ArrayList<>();
        mID = Integer.toString(hashCode());
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

    public String getID() {
        return mID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Routine routine = (Routine) o;
        return mID.equals(routine.mID) &&
                mName.equals(routine.mName) &&
                mHabitList.equals(routine.mHabitList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mName);
    }
}
