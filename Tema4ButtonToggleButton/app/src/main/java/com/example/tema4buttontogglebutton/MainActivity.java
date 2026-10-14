package com.example.tema4buttontogglebutton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    protected void onStart(){
        super.onStart();
        Button boton1 = findViewById(R.id.boton1);
        TextView texto = findViewById(R.id.texto);
        boton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                texto.setText("Se ha pulsado el botón");

                int id = view.getId();
                if (id == R.id.boton1){

                }else if (id == R.id.boton2){

                }
                
            }
        });
    }
}