package com.example.tema4intefacesdeusario;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

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
        Animation miAnimation = AnimationUtils.loadAnimation(
                this, R.anim.animacion);

        miAnimation.setRepeatMode(Animation.RESTART);
        miAnimation.setRepeatCount(20);

        miTexto.startAnimation(miAnimation);

    }
}