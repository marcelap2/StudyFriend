package com.example.studyfriendapp.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.TextView;


import com.example.studyfriendapp.R;

public class Agenda extends AppCompatActivity {

    CalendarView calendarView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        textView = (TextView) findViewById(R.id.text_caledar);

    }


}
