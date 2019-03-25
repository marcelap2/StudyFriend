package com.example.studyfriendapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_add_groupclass extends AppCompatActivity {

    Button buttonaddgroupclass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_groupclass);

        buttonaddgroupclass = (Button) findViewById(R.id.buttonaddgroupclass);

        buttonaddgroupclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity_add_groupclass.this, activity_add_recordatory.class);
                startActivity(i);
            }
        });
    }
}
