package com.daniel.android.relifemanager;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RoutineViewAdapter extends RecyclerView.Adapter<RoutineViewAdapter.RoutineViewHolder> {

    private List<Routine> mRoutineList;

    /*
    Provide a reference to the views for each data item
    Complex data items may need more than one view per item, and you
    provide access to all the views for a data item in a view holder
     */
    public static class RoutineViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public View mView;

        // Each data item is just a string of the Routine name
        public RoutineViewHolder(@NonNull View view) {
            super(view);
            mView = view;
            textView = view.findViewById(R.id.textView_routine);

        }


    }

    public RoutineViewAdapter(List<Routine> routineList) {
        mRoutineList = routineList;
    }

    // Create new views
    @Override
    public RoutineViewAdapter.RoutineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create new view
        // --> base of view_routine may need to be changed to TextView
        View view = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.view_routine, parent, false);
        //TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.view_routine, parent, false);
        RoutineViewHolder routineViewHolder = new RoutineViewHolder(view);
        return routineViewHolder;
    }

    // replaces the contents of a ViewHolder
    @Override
    public void onBindViewHolder(@NonNull RoutineViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(mRoutineList.get(position).getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create an intent
                Intent intent = new Intent(v.getContext(), RoutineDetailActivity.class);
                // put details into intent
                intent.putExtra("ROUTINE_NAME", mRoutineList.get(position).getName());
                // switch to Routine detail activity
                v.getContext().startActivity(intent);
            }
        });
    }

    // gets the size of dataset, invoked by the layout manager
    @Override
    public int getItemCount() {
        return mRoutineList.size();
    }
}
