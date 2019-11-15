package com.daniel.android.relifemanager;

import java.util.ArrayList;
import java.util.UUID;

public class RoutineModel {

    private static ArrayList<Routine> mRoutineList;

    public RoutineModel() {
        mRoutineList = new ArrayList<>();
    }

    public Routine getRoutineById(UUID id) {
        if(!mRoutineList.isEmpty() || containsID(id)) {
            for (int i = 0; i < mRoutineList.size(); i++){
                if(mRoutineList.get(i).getUUID() == id) {
                    return mRoutineList.get(i);
                }
            }
        }
        return null;
    }

    public boolean containsID(UUID id) {
        for (int i = 0; i < mRoutineList.size(); i++){
            if(mRoutineList.get(i).getUUID() == id){
                return true;
            }
        }
        return false;
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
