package com.example.tema4buttontogglebutton;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.CompoundButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Animation miAnimation;
    private Animation miAnimation2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        TextView miTexto = findViewById(R.id.texto);

        miTexto.setText("Nuevo texto a mostrar");

        // Cambiar el color del texto
        miTexto.setTextColor(Color.RED);

        // Cambiar el texto a cursiva
        miTexto.setTypeface(null, Typeface.ITALIC);

        // Cambiar el tamaño
        miTexto.setTextSize(24);

        // Cambiar el tipo de letra
        miTexto.setTypeface(Typeface.SANS_SERIF);

        // Aplicar animación de rotación
        miAnimation = AnimationUtils.loadAnimation(this, R.anim.translate);

        miAnimation.setRepeatMode(Animation.RESTART);
        miAnimation.setRepeatCount(20);

        TextView miTexto2 = findViewById(R.id.texto2);

        miTexto2.setText("Nuevo texto a mostrar");

        // Cambiar el color del texto
        miTexto2.setTextColor(Color.RED);

        // Cambiar el texto a cursiva
        miTexto2.setTypeface(null, Typeface.ITALIC);

        // Cambiar el tamaño
        miTexto2.setTextSize(24);

        // Cambiar el tipo de letra
        miTexto2.setTypeface(Typeface.SANS_SERIF);

        // Aplicar animación de rotación
        miAnimation2 = AnimationUtils.loadAnimation(this, R.anim.rotate);

        miAnimation2.setRepeatMode(Animation.RESTART);
        miAnimation2.setRepeatCount(80);

        // Controlar las animaciones con el ToggleButton
        ToggleButton tgboton = findViewById(R.id.tgboton);

        tgboton.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(
                            CompoundButton buttonView, boolean isChecked) {

                        if (isChecked) {
                            // Iniciar las dos animaciones
                            miTexto.startAnimation(miAnimation);
                            miTexto2.startAnimation(miAnimation2);
                        } else {
                            // Detener las dos animaciones
                            miTexto.clearAnimation();
                            miTexto2.clearAnimation();
                        }
                    }
                });
    }

    public void onClick(View view) {

    }

}
