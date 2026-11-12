package com.example.proyecto2_gestioncuentabar;

import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Button;
import android.widget.TextView;
import android.widget.AutoCompleteTextView;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.NumberFormat;
import java.util.Currency;

public class MainActivity extends AppCompatActivity {

    EditText etCuenta;
    CheckBox cbPropina;
    SeekBar seekPropina;
    TextView tvPorcentaje;
    RadioGroup rgPago;
    RatingBar ratingServicio;
    Button btnCalcular;
    TextView tvResultado;
    AutoCompleteTextView actvCamarero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Ajustar la pantalla
        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (v, insets) -> {

                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars());

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                });

        // Relacionar los controles XML con Java
        etCuenta = findViewById(R.id.etCuenta);
        cbPropina = findViewById(R.id.cbPropina);
        seekPropina = findViewById(R.id.seekPropina);
        tvPorcentaje = findViewById(R.id.tvPorcentaje);
        rgPago = findViewById(R.id.rgPago);
        ratingServicio = findViewById(R.id.ratingServicio);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);
        actvCamarero = findViewById(R.id.actvCamarero);

        // Lista de camareros
        String[] camareros = {
                "Carlos",
                "María",
                "Javier",
                "Laura",
                "Pedro",
                "Ana"
        };

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                camareros
        );

        actvCamarero.setAdapter(adaptador);
        actvCamarero.setThreshold(3);

        // Actualizar el porcentaje de propina
        seekPropina.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(
                            SeekBar seekBar, int progress, boolean fromUser) {

                        tvPorcentaje.setText(
                                getString(R.string.porcentaje, progress)
                        );
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });

        // Botón para calcular la cuenta
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularCuenta();
            }
        });
    }

    //Med calcular cuenta
    private void calcularCuenta() {

        String textoCuenta = etCuenta.getText().toString().trim();

        // Comprobar si el campo está vacío
        if (textoCuenta.isEmpty()) {
            mostrarError(getString(R.string.error_vacio));
            return;
        }

        // Comprobar que el formato sea numérico
        if (!textoCuenta.matches("-?(\\d+([.,]\\d*)?|[.,]\\d+)")) {
            mostrarError(getString(R.string.error_numero));
            return;
        }

        double cuenta;

        try {
            cuenta = Double.parseDouble(textoCuenta.replace(',', '.'));
        } catch (NumberFormatException e) {
            mostrarError(getString(R.string.error_numero));
            return;
        }

        // Comprobar que el importe sea mayor que cero
        if (cuenta <= 0 || Double.isInfinite(cuenta)
                || Double.isNaN(cuenta)) {

            mostrarError(getString(R.string.error_positivo));
            return;
        }

        // Calcular la propina
        double propina = 0;

        if (cbPropina.isChecked()) {
            int porcentaje = seekPropina.getProgress();
            propina = cuenta * porcentaje / 100;
        }

        // Calcular el total
        double total = cuenta + propina;

        // Obtener el método de pago
        int seleccion = rgPago.getCheckedRadioButtonId();

        String metodoPago;

        if (seleccion == R.id.rbEfectivo) {
            metodoPago = getString(R.string.efectivo);
        } else if (seleccion == R.id.rbTarjeta) {
            metodoPago = getString(R.string.tarjeta);
        } else {
            mostrarError(getString(R.string.error_pago));
            return;
        }

        // Obtener la valoración del servicio
        float valoracion = ratingServicio.getRating();

        // Obtener el nombre del camarero
        String camarero = actvCamarero.getText().toString().trim();

        if (camarero.isEmpty()) {
            camarero = getString(R.string.no_indicado);
        }

        // Formatear los importes en euros
        NumberFormat formato = NumberFormat.getCurrencyInstance();
        formato.setCurrency(Currency.getInstance("EUR"));

        String cuentaTexto = formato.format(cuenta);
        String propinaTexto = formato.format(propina);
        String totalTexto = formato.format(total);

        // Mostrar el resultado
        tvResultado.setText(getString(
                R.string.resultado_calculado,
                cuentaTexto,
                propinaTexto,
                totalTexto,
                metodoPago,
                valoracion,
                camarero
        ));

        tvResultado.setTextColor(Color.DKGRAY);
    }

    // Mostrar los errores en rojo
    private void mostrarError(String mensaje) {

        tvResultado.setText(mensaje);
        tvResultado.setTextColor(Color.RED);
    }
}
