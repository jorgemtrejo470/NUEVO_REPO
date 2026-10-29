package com.example.practica1calculadora;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridlayout_calcu);

        // Obtenemos la pantalla de la calculadora
        TextView pantalla = findViewById(R.id.textoCalcu);

        // Botones numéricos
        int[] idsNumeros = {
                R.id.btn0, R.id.btn1, R.id.btn2,
                R.id.btn3, R.id.btn4, R.id.btn5,
                R.id.btn6, R.id.btn7, R.id.btn8,
                R.id.btn9
        };

        // Asignamos el evento a cada botón numérico
        for (int id : idsNumeros) {
            Button boton = findViewById(id);

            boton.setOnClickListener(v -> {
                String numero = boton.getText().toString();
                escribirNumero(pantalla, numero);
            });
        }

        // Botón de la coma decimal
        Button btnComa = findViewById(R.id.btnComa);
        btnComa.setOnClickListener(v -> escribirComa(pantalla));

        // Botones de operaciones
        int[] idsOperaciones = {
                R.id.btnSuma, R.id.btnResta,
                R.id.btnMultiplicacion, R.id.btnDivision
        };

        // Asignamos el evento a cada operación
        for (int id : idsOperaciones) {
            Button boton = findViewById(id);

            boton.setOnClickListener(v -> {
                String operacion = boton.getText().toString();
                escribirOperacion(pantalla, operacion);
            });
        }

        // Botón C: borra el último carácter
        Button btnC = findViewById(R.id.btnC);
        btnC.setOnClickListener(v -> borrarUltimo(pantalla));

        // Botón AC: borra todo
        Button btnAC = findViewById(R.id.btnAC);
        btnAC.setOnClickListener(v -> pantalla.setText("0"));

        // Botón igual: no calcula porque es opcional
        Button btnIgual = findViewById(R.id.btnIgual);
        btnIgual.setOnClickListener(v -> {
            // Sin funcionalidad según la rúbrica.
        });
    }

    // Escribe un número evitando ceros iniciales
    private void escribirNumero(TextView pantalla, String numero) {
        String texto = pantalla.getText().toString();
        String ultimoNumero = obtenerUltimoNumero(texto);

        if (texto.equals("0")) {
            pantalla.setText(numero);
        } else if (ultimoNumero.equals("0")) {
            pantalla.setText(
                    texto.substring(0, texto.length() - 1) + numero
            );
        } else {
            pantalla.setText(texto + numero);
        }
    }

    // Añade una coma si el número actual no tiene otra
    private void escribirComa(TextView pantalla) {
        String texto = pantalla.getText().toString();
        String ultimoNumero = obtenerUltimoNumero(texto);

        if (!ultimoNumero.contains(",")) {
            if (ultimoNumero.isEmpty()) {
                pantalla.setText(texto + "0,");
            } else {
                pantalla.setText(texto + ",");
            }
        }
    }

    // Añade una operación sin calcular el resultado
    private void escribirOperacion(TextView pantalla, String operacion) {
        String texto = pantalla.getText().toString();

        if (texto.equals("0") || texto.endsWith(",")) {
            return;
        }

        String ultimoCaracter = texto.substring(texto.length() - 1);

        if (esOperacion(ultimoCaracter)) {
            return;
        }

        pantalla.setText(texto + operacion);
    }

    // Obtiene el último número de la expresión
    private String obtenerUltimoNumero(String texto) {
        int posicion = -1;

        for (int i = 0; i < texto.length(); i++) {
            String caracter = texto.substring(i, i + 1);

            if (esOperacion(caracter)) {
                posicion = i;
            }
        }

        return texto.substring(posicion + 1);
    }

    // Comprueba si un carácter es un operador
    private boolean esOperacion(String caracter) {
        return caracter.equals("+")
                || caracter.equals("−")
                || caracter.equals("×")
                || caracter.equals("÷");
    }

    // Borra el último carácter
    private void borrarUltimo(TextView pantalla) {
        String texto = pantalla.getText().toString();

        if (texto.length() > 1) {
            String nuevoTexto = texto.substring(0, texto.length() - 1);

            if (nuevoTexto.isEmpty() || nuevoTexto.equals("−")) {
                pantalla.setText("0");
            } else {
                pantalla.setText(nuevoTexto);
            }
        } else {
            pantalla.setText("0");
        }
    }
}
