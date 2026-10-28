
package com.example.tema4buttontogglebutton;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.linear);

        ProgressBar pb = findViewById(R.id.pbDet);
        TextView tvProgreso = findViewById(R.id.tvProgreso);

        Handler handler = new Handler(Looper.getMainLooper());

        new Runnable() {
            int v = 0;

            @Override
            public void run() {
                if (v <= 100) {
                    pb.setProgress(v);
                    tvProgreso.setText("Progreso: " + v + "%");

                    v += 5;

                    if (v <= 100) {
                        handler.postDelayed(this, 200);
                    }
                }
            }
        }.run();
    }
}
