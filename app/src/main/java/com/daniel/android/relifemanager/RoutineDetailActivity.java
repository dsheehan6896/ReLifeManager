package com.daniel.android.relifemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RoutineDetailActivity extends AppCompatActivity {

    private Intent mIntent;
    private EditText mEditTextName;

    private Button mButtonDelete;
    private Button mButtonEdit;
    private Button mButtonSave;
    private Button mButtonCancel;

    private String mName;

    private String mID;

    // INFO ON ENIABLING/DISABLING PLAINTEXT EDIT
    // editText.setFocusable(false) to disable
    // editText.setFocusableInTouchMode(true) to enable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine_detail);

        // grab intent
        mIntent = getIntent();
        // get extras
        mName = mIntent.getStringExtra("ROUTINE_NAME");
        mID = mIntent.getStringExtra("ID");
        Log.d("ID", "ID is " + mID);
        // assign name editText
        mEditTextName = findViewById(R.id.editText_routineDetail_name);
        // disable name editing by default
        mEditTextName.setFocusable(false);
        // set name
        mEditTextName.setText(mName);

        mButtonEdit = findViewById(R.id.button_routineDetail_edit);
        mButtonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ALLOWS EDITING
                enableEditing();
            }
        });

        mButtonDelete = findViewById(R.id.button_routineDetail_delete);
        mButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open delete confirmation prompt (fragment)
            }
        });

        mButtonSave = findViewById(R.id.button_routineDetail_save);
        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // disable editing
                disableEditing();
                mName = mEditTextName.getText().toString();
                mEditTextName.setText(mName);

                // save info and pass to RoutineActivity
                Intent intent = new Intent(v.getContext(), RoutineActivity.class);
                intent.putExtra("START_INTENT", false);
                intent.putExtra("ROUTINE_NAME", mName);
                intent.putExtra("ID", mID);

                // move to RoutineActivity
                v.getContext().startActivity(intent);
            }
        });

        mButtonCancel = findViewById(R.id.button_routineDetail_cancel);
        mButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // disable editing
                disableEditing();
                mEditTextName.setText(mName);
            }
        });
    }

    private void enableEditing() {
        // disable buttons
        mButtonEdit.setVisibility(View.GONE);
        mButtonDelete.setVisibility(View.GONE);
        // enable buttons
        mButtonSave.setVisibility(View.VISIBLE);
        mButtonCancel.setVisibility(View.VISIBLE);

        // activate EditText
        mEditTextName.setFocusableInTouchMode(true);
        // selects EditText and opens keyboard
        mEditTextName.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(mEditTextName, InputMethodManager.SHOW_IMPLICIT);
    }

    private void disableEditing() {
        // disable buttons
        mButtonSave.setVisibility(View.GONE);
        mButtonCancel.setVisibility(View.GONE);
        // enable buttons
        mButtonEdit.setVisibility(View.VISIBLE);
        mButtonDelete.setVisibility(View.VISIBLE);
    }
}
