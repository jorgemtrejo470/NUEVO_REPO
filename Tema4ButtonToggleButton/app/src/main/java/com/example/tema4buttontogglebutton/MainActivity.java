package com.example.tema4buttontogglebutton;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Estos son los elementos que se sugerirán
        String [] opciones= {"Opción1","Opción2","Opción3","Opción4","Opción5"};
        //Aqui se asigna el elemento AutocompleteTextView creado en el XML al Java
        AutoCompleteTextView textoLeido = findViewById(R.id.miTexto);
        //Creamos un Array adapter al que le pasamos el array de strings
        //la mision de este "ArrayAdapter" es Adaptar los datos del array al AutocomplteTextView
        ArrayAdapter<String> adaptador= new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,opciones);
        //Por último se le pasa al adaptador la instancia del texto definida en el xml
        textoLeido.setAdapter(adaptador);
    }
}
