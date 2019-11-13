package com.daniel.android.relifemanager;

import java.util.ArrayList;
import java.util.List;

public class RoutineModel {

    private static ArrayList<Routine> mRoutineList;

    public RoutineModel() {
        mRoutineList = new ArrayList<>();
    }

    public Routine getRoutineAt(int index) {
        if(index < mRoutineList.size()) {
            return mRoutineList.get(index);
        } else {
            return null;
        }
    }

    public ArrayList<Routine> getRoutineList() {
        if(!mRoutineList.isEmpty()) {
            return mRoutineList;
        } else {
            ArrayList<Routine> test = new ArrayList<>();
            test.add(new Routine());
            return test;
        }
    }

    public void addRoutine(Routine routine) {
        mRoutineList.add(routine);
    }

    public boolean removeRoutine(int index) {
        if(!mRoutineList.isEmpty() || index < mRoutineList.size()) {
            mRoutineList.remove(index);
            return true;
        } else {
            return false;
        }
    }
}
