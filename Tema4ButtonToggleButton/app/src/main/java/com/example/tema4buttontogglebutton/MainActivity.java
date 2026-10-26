package com.example.tema4buttontogglebutton;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Buscamos los elementos del XML
        Switch switch1 = findViewById(R.id.switch1);
        TextView textViewStatus = findViewById(R.id.textViewStatus);

        // Listener para detectar el cambio de estado del Switch
        switch1.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(
                            CompoundButton buttonView,
                            boolean isChecked) {

                        if (isChecked) {
                            // El Switch está encendido
                            textViewStatus.setText("Estado: Encendido");

                        } else {
                            // El Switch está apagado
                            textViewStatus.setText("Estado: Apagado");
                        }
                    }
                }
        );
    }
}
