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

        // Opciones que aparecerán en el AutoCompleteTextView
        String[] opciones = {
                "Opción1",
                "Opción2",
                "Opción3",
                "Opción4",
                "Opción5"
        };

        // Buscamos el AutoCompleteTextView definido en el XML
        AutoCompleteTextView textoLeido = findViewById(R.id.miTexto);

        // Creamos el adaptador para las sugerencias
        ArrayAdapter<String> adaptadorTexto = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                opciones
        );

        // Asignamos el adaptador al campo de texto
        textoLeido.setAdapter(adaptadorTexto);

        // Buscamos el Spinner definido en el XML
        Spinner miSpinner = findViewById(R.id.miSpinner);

        // Películas que aparecerán en el Spinner
        String[] valores = {
                "Star Wars",
                "Reservoir dogs",
                "El club de la lucha",
                "Snatch: Cerdos y Diamantes"
        };

        // Creamos el adaptador del Spinner
        ArrayAdapter<String> adaptadorSpinner = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                valores
        );

        // Definimos el diseño de las opciones desplegables
        adaptadorSpinner.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        // Asignamos el adaptador al Spinner
        miSpinner.setAdapter(adaptadorSpinner);

        // Detectamos cuándo se selecciona una película
        miSpinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(
                            AdapterView<?> adapterView,
                            View view,
                            int position,
                            long id) {

                        String pelicula =
                                adapterView.getItemAtPosition(position).toString();

                        System.out.println(
                                "Has seleccionado el valor: " + pelicula
                        );
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                        System.out.println("No has seleccionado nada");
                    }
                }
        );
    }
}
