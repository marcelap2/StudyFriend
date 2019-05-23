package com.example.studyfriendapp.Activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studyfriendapp.R;

public class details_events extends AppCompatActivity {

    TextView textView;
    ImageView imagen;
    String playText;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_events);


        textView = (TextView) findViewById(R.id.texrdetailE);
        imagen = (ImageView) findViewById(R.id.image_eventos);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton_add);

        playText = getIntent().getStringExtra("texto");
        textView.setText("No tienes " + playText + " Hoy");

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playText.equalsIgnoreCase("clases")){
                    Intent i = new Intent(v.getContext(), activity_add_class.class);
                    v.getContext().startActivity(i);
                }else if (playText.equalsIgnoreCase("eventos")){
                    Intent i = new Intent(v.getContext(), activity_add_event.class);
                    v.getContext().startActivity(i);
                }else if (playText.equalsIgnoreCase("examenes")){
                    Intent i = new Intent(v.getContext(), activity_add_examen.class);
                    v.getContext().startActivity(i);
                }else if (playText.equalsIgnoreCase("tareas")){
                    Intent i = new Intent(v.getContext(), activity_add_tareas.class);
                    v.getContext().startActivity(i);
                }
            }
        });

    }



}
