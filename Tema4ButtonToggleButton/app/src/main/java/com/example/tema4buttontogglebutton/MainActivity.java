package com.example.tema4buttontogglebutton;

import android.os.Bundle;
import android.widget.RatingBar;
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
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        TextView textViewRating = findViewById(R.id.textViewRating);

        // Listener para cambios en la calificación del RatingBar
        ratingBar.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {

                    @Override
                    public void onRatingChanged(
                            RatingBar ratingBar,
                            float rating,
                            boolean fromUser) {

                        // Actualizar el TextView con la calificación seleccionada
                        textViewRating.setText(
                                "Calificación: " + rating
                        );
                    }
                }
        );
    }
}


