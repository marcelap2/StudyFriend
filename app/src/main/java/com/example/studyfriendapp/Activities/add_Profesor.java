package com.example.studyfriendapp.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


import com.example.studyfriendapp.R;

public class add_Profesor extends AppCompatActivity {

    private TextView name;
    private TextView materia;
    private TextView telefono;
    private TextView email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_profesor);

        name = (TextView) findViewById(R.id.name_profesor);



    }
}


