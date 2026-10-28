package com.example.tema4buttontogglebutton;

import android.os.Bundle;
import android.widget.SeekBar;
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
        SeekBar seekBar = findViewById(R.id.seekBar);
        TextView textViewProgress = findViewById(R.id.textViewProgress);

        // Listener para detectar cambios en el SeekBar
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    // Se ejecuta cuando cambia el progreso
                    @Override
                    public void onProgressChanged(
                            SeekBar seekBar,
                            int progress,
                            boolean fromUser) {

                        textViewProgress.setText(
                                "Volumen: " + progress
                        );
                    }

                    // Se ejecuta cuando el usuario empieza a mover la barra
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                        // Aquí podemos añadir código si lo necesitamos
                    }

                    // Se ejecuta cuando el usuario termina de mover la barra
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                        // Aquí podemos añadir código si lo necesitamos
                    }
                }
        );
    }
}

