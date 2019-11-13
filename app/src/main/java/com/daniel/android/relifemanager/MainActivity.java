package com.daniel.android.relifemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // AUTOMATICALLY SWITCHES ACTIVITY
        Intent mainIntent = new Intent(MainActivity.this, RoutineActivity.class);
        MainActivity.this.startActivity(mainIntent);
        MainActivity.this.finish();
    }
}
