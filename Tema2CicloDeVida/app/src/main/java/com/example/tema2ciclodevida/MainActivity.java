package com.example.tema2ciclodevida;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

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
        Log.i("Ejemplo","Estoy en on Destroy");
        Intent ejemplo = new Intent(this, MainActivity2.class);
        startActivity(ejemplo);
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Ejemplo","Estoy en on Start");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Ejemplo","Estoy en on Restart");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Ejemplo","Estoy en on Resume");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i("Ejemplo","Estoy en on Pause");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Ejemplo","Estoy en on Stop");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Ejemplo","Estoy en on Destroy");
    }
}