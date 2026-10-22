package com.example.tema4buttontogglebutton;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

   protected void onStart(){
        super.onStart();
       setContentView(R.layout.activity_main);
       Spinner miSpinner = (Spinner) findViewById(R.id.miSpinner);
       String[] valores = {"Star Wars", "Reservoir dogs", "El club de la lucha", "Snach: Cerdos y Diamantes"};

       miSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));

       miSpinner.setOnItemSelectedListener(new AdapterView.OnItemClickListener(){
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
               System.out.println("Has seleccionado el valor"+adapterView.getItemAtPosition(position));
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView){
               System.out.println("No has selecionado nada");
           }
       }
   }
}
