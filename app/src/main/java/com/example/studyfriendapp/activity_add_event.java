package com.example.studyfriendapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_add_event extends AppCompatActivity {


    Button buttonAddE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
         buttonAddE = (Button) findViewById(R.id.buttonaddevent);
         buttonAddE.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i = new Intent (activity_add_event.this, activity_add_class.class);
                 startActivity(i);
             }
         });

    }
}
