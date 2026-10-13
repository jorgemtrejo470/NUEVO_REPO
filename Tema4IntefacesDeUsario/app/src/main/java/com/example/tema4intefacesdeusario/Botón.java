
package com.example.tema4intefacesdeusario;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class Boton extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_boton);
    }

    @Override
    protected void onStart() {
        super.onStart();

        TextView miTexto = findViewById(R.id.texto);

        miTexto.setText("Nuevo texto a mostrar");

        // Cambiar el color del texto
        miTexto.setTextColor(Color.parseColor("#0000FF"));
        miTexto.setTextColor(Color.RED);

        // Cambiar el estilo del texto
        miTexto.setTypeface(null, Typeface.ITALIC);

        // Cambiar el tamaño del texto
        miTexto.setTextSize(24);

        // Cambiar el tipo de letra
        miTexto.setTypeface(Typeface.SANS_SERIF);

        // Animación Translate
        Animation animacionTranslate =
                AnimationUtils.loadAnimation(this, R.anim.translate);

        animacionTranslate.setRepeatMode(Animation.RESTART);
        animacionTranslate.setRepeatCount(20);

        miTexto.startAnimation(animacionTranslate);

        // Animación Rotate
        Animation animacionRotate =
                AnimationUtils.loadAnimation(this, R.anim.rotate);

        animacionRotate.setRepeatMode(Animation.RESTART);
        animacionRotate.setRepeatCount(20);

        // Ejecutar Rotate al pulsar el botón
        Button miBoton = findViewById(R.id.boton);

        miBoton.setOnClickListener(v ->
                miTexto.startAnimation(animacionRotate));
    }
}

