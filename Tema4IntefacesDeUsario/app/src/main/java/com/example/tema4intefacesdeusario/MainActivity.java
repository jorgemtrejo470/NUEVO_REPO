package com.example.tema4intefacesdeusario;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    protected  void onStart(){
        super.onStart();
        TextView miTexto = findViewById(R.id.texto);
        miTexto.setText("Nuevo texto a mostrar");
        //Opción uno para cambiar el color
        miTexto.setTextColor(Color.parseColor("#0000FF"));
        //Opción 2 para cambiar el color
        miTexto.setTextColor(Color.RED);
        //Cambio texto a negrita
        miTexto.setTypeface(null, Typeface.ITALIC);
        miTexto.setTextSize(24);
        //Cambiar tipo de letra
        miTexto.setTypeface(Typeface.SANS_SERIF);
        //Anmación de Translade & Rotate
        Animation miAnimation= AnimationUtils.loadAnimation(this, R.anim.rotate);
        miAnimation.setRepeatMode(Animation.RESTART);
        miAnimation.setRepeatCount(20);
        miTexto.startAnimation(miAnimation);
    }
}