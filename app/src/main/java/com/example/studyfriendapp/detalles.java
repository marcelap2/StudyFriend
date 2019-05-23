package com.example.studyfriendapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studyfriendapp.Activities.Agenda;
import com.example.studyfriendapp.Activities.activity_add_class;

public class detalles extends AppCompatActivity {

    TextView textView;
    ImageView imagen;
    String playText;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);


       // textView = (TextView) findViewById(R.id.texrdetailE);
     //   imagen = (ImageView) findViewById(R.id.image_eventos);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);

        playText = getIntent().getStringExtra("texto");
        //textView.setText("No tienes " + playText + " Hoy");

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playText.equalsIgnoreCase("clases")){
                    Intent i = new Intent(v.getContext(), activity_add_class.class);
                    v.getContext().startActivity(i);
                }
            }
        });

}

}
