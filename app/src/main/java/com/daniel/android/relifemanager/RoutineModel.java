package com.daniel.android.relifemanager;

import android.util.Log;

import java.util.ArrayList;

public final class RoutineModel {

    private static ArrayList<Routine> mRoutineList;

    public RoutineModel() {
        mRoutineList = new ArrayList<>();
    }

    public Routine getRoutineById(String id) {
        if(!mRoutineList.isEmpty() || containsID(id)) {
            for (int i = 0; i < mRoutineList.size(); i++){
                if(mRoutineList.get(i).getID().equals(id)) {
                    return mRoutineList.get(i);
                }
            }
        }
        return null;
    }

    public boolean containsID(String id) {
        for (int i = 0; i < mRoutineList.size(); i++){
            Log.d("ITERATION", "Iteration " + i);
            String uuid = mRoutineList.get(i).getID();
            Log.d("UID", "ID " + i + " = " + uuid);
            if(uuid.equals(id)){
                Log.d("CONTAINSID", "true");
                return true;
            }
        }
        Log.d("CONTAINSID", "false");
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
