package com.example.tema4buttontogglebutton;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ImageButton botonImagen = findViewById(R.id.botonImagen);
        ToggleButton boton1 = findViewById(R.id.boton1);

        boton1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                botonImagen.setVisibility(View.VISIBLE);
            } else {
                botonImagen.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
