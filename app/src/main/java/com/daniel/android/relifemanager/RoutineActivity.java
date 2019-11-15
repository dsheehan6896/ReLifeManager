package com.daniel.android.relifemanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.UUID;

public class RoutineActivity extends AppCompatActivity {

    // The one and only Routine Model
    private static RoutineModel mRoutineModel;

    // RecyclerView stuff
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);

        mRoutineModel = new RoutineModel();

        // test routines
        mRoutineModel.addRoutine(new Routine("Test1"));
        mRoutineModel.addRoutine(new Routine("Test2"));
        mRoutineModel.addRoutine(new Routine("Test3"));

        /* Setup RecyclerView */
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_routine_list);
        mLayoutManager = new LinearLayoutManager(this); // so it works like a list
        mRecyclerView.setLayoutManager(mLayoutManager); // assigns layout manager to the view
        mAdapter = new RoutineViewAdapter(mRoutineModel.getRoutineList()); // specifies an adapter and passes the data to display
        mRecyclerView.setAdapter(mAdapter); // assigns adapter to the view

    }

    @Override
    public void onResume() {
        super.onResume();
        if(mAdapter != null) {
            Intent intent = getIntent();
            boolean isStart = intent.getBooleanExtra("START_INTENT", true);
            if (isStart == false) {
                UUID id = UUID.fromString(intent.getStringExtra("UUID"));
                String name = intent.getStringExtra("ROUTINE_NAME");
                if (mRoutineModel.containsID(id)) {
                    mRoutineModel.getRoutineById(id).setName(name);
                }
            }
            updateUI();


        }
    }

    private void updateUI() {
        mAdapter.notifyDataSetChanged();
    }
}
