package com.example.listados_y_menus;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.listview);

        //Datos de ejemplo para la lista
        List<String> data = Arrays.asList("Alemania", "España", "Francia", "Polonia", "Portugal", "Italia",
                "Noruega", "Croacia", "Grecia", "Paises Bajos");

        //Configurar el ListView y asignarle el adaptador
        ListView listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);
    }
}