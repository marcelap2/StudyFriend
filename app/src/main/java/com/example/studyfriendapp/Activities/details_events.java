package com.example.studyfriendapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studyfriendapp.R;

public class details_events extends AppCompatActivity {

    TextView textView;
    ImageView imagen;
    String playText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_events);


        textView = (TextView) findViewById(R.id.texrdetailE);
        imagen = (ImageView) findViewById(R.id.image_eventos);

        playText = getIntent().getStringExtra("texto");
        textView.setText("No tienes " + playText + " Hoy");

    }



}
