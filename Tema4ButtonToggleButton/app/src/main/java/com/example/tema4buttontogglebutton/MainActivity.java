package com.example.tema4buttontogglebutton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
        RadioGroup radioGroup = findViewById(R.id.radiogroup);
        Button buttonCheck = findViewById(R.id.buttonCheck);
        TextView textViewResult = findViewById(R.id.textViewResult);

        // Listener para comprobar la selección
        buttonCheck.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // Obtenemos el ID del RadioButton seleccionado
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // Comprobamos si hay alguna opción seleccionada
                if (selectedId != -1) {

                    // Buscamos el RadioButton seleccionado
                    RadioButton selectedRadioButton =
                            findViewById(selectedId);

                    // Obtenemos el texto de la opción
                    String selectedOption =
                            selectedRadioButton.getText().toString();

                    // Mostramos la opción elegida
                    textViewResult.setText(
                            "Seleccionado: " + selectedOption
                    );

                } else {

                    // No se ha seleccionado ninguna opción
                    textViewResult.setText(
                            "No has seleccionado ninguna opción"
                    );
                }
            }
        });
    }
}

