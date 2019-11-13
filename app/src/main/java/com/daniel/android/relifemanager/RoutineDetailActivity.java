package com.daniel.android.relifemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RoutineDetailActivity extends AppCompatActivity {

    private Intent mIntent;
    private EditText mEditTextName;
    private Button mButtonEdit;

    private String mName;

    // INFO ON ENIABLING/DISABLING PLAINTEXT EDIT
    // editText.setFocusable(false) to disable
    // editText.setFocusableInTouchMode(true) to enable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine_detail);

        // grab intent
        mIntent = getIntent();
        // get name
        mName = mIntent.getStringExtra("ROUTINE_NAME");
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
                mEditTextName.setFocusableInTouchMode(true);
            }
        });


    }
}
