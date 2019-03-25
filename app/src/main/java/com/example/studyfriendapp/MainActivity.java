package com.example.studyfriendapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listatareas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listatareas = (ListView) findViewById(R.id.lista);
        ArrayList<String> tareas = new ArrayList<>();
        tareas.add("Examen");
        tareas.add("Clase calculo");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, tareas);
            listatareas.setAdapter(adapter);

           listatareas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   Intent i= new Intent(MainActivity.this,activity_add_event.class);
                   startActivity(i);
               }
           });

    }
}
