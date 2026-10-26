package com.example.tema4buttontogglebutton;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Buscamos el CheckBox definido en el XML
        CheckBox checkbox1 = findViewById(R.id.checkbox1);

        // Listener para detectar cambios en el CheckBox
        checkbox1.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(
                            CompoundButton buttonView,
                            boolean isChecked) {

                        if (isChecked) {
                            // Código cuando está seleccionado
                            Toast.makeText(
                                    MainActivity.this,
                                    "Has marcado la opción",
                                    Toast.LENGTH_SHORT
                            ).show();

                        } else {
                            // Código cuando no está seleccionado
                            Toast.makeText(
                                    MainActivity.this,
                                    "Has desmarcado la opción",
                                    Toast.LENGTH_SHORT
                            ).show();
                        }
                    }
                }
        );
    }
}
