package com.example.studyfriendapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.studyfriendapp.R;

public class activity_add_event extends AppCompatActivity {


    Button buttonAddE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_evento);
         buttonAddE = (Button) findViewById(R.id.buttonaddevent);
         buttonAddE.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });

    }
}
